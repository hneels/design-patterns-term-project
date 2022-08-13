package student;

/* This class imitates a database and maintains a map of Students to Thesis objects, which may be either complete or
in progress. This class could be created as a singleton, but is not because it uses statics instead of singleton objects.
There is no need for Singleton in this case because ThesisDatabase doesn't leverage polymorphism.

The purpose of this class is to create a separate structure to map eligible Students to Theses, since not all Students will have a Thesis.
 */

import java.util.HashMap;
import java.util.Map;

public class ThesisDatabase {

    // a record of all theses either in-progress or completed
    private static Map<Student, Thesis> studentMap = new HashMap<>();


    // new theses are automatically added to this database by the Thesis class constructor
    public static void addThesis(Student student, Thesis thesis) {
        System.out.println("Adding " + student + "'s thesis to the database");
        studentMap.put(student, thesis);
    }

    // get a thesis from the database by student
    public static Thesis getThesis(Student student) {
        System.out.println("Checking database for " + student + "'s thesis");
        return studentMap.get(student);
    }



}
