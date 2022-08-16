package student;

/* This class imitates a database and maintains a map of Students to Thesis objects, which may be either complete or
in progress. It also maintains a list of FullTimeFaculty to their student thesis advisees -- only those whose thesis is in-progress.
This class could be created as a singleton, but is not because it uses statics instead of singleton objects.
There is no need for Singleton in this case because ThesisDatabase doesn't use polymorphism.

The purpose of this class is to create a separate structure to map eligible Students to Theses, since not all Students will have a Thesis
 and FullTimeFaculty need an easy way to access all their advisees.
 */

import faculty.FullTimeFaculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThesisDatabase {

    // a record of all theses either in-progress or completed
    private static Map<Student, Thesis> studentMap = new HashMap<>();

    // a record of all thesis advisors to the students they advise
    private static Map<FullTimeFaculty, List<Student>> advisorMap = new HashMap<>();


    // new theses are automatically added to this database by the Thesis class constructor
    public static void addThesis(Thesis thesis) {
        Student student = thesis.getStudent();
        System.out.println("Adding " + student + "'s thesis to the database");
        studentMap.put(student, thesis);

        // also keep track of all Thesis writers whom professors advise
        List<Student> adviseeList = advisorMap.getOrDefault(thesis.getAdvisor(), new ArrayList<>());
        adviseeList.add(student);
        advisorMap.put(thesis.getAdvisor(), adviseeList);
    }

    // get a thesis from the database by student
    public static Thesis getThesis(Student student) {
        System.out.println("Checking database for " + student + "'s thesis");
        return studentMap.get(student);
    }

    /* the ThesisDatabase keeps track of all in-progress theses AND completed theses, but student advisees should be removed
    from a professor's Advisee list once the thesis is completed.
    this method is invoked from thesis.complete() method
     */
    public static void removeAdvisee(FullTimeFaculty advisor, Student student) {
        List<Student> adviseeList = advisorMap.get(advisor);
        if (adviseeList != null && adviseeList.contains(student)) {
            adviseeList.remove(student);
        }
    }

    // requirement: faculty should easily know the students they are currently advising (invoked from FullTimeFaculty's showAdvisees() method)
    public static List<Student> getAdvisees(FullTimeFaculty faculty) {
        return advisorMap.get(faculty);
    }


}
