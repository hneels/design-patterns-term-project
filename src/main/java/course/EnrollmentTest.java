package course;

/* This test class demonstrates the Observer pattern.
 It also demonstrates the following requirements from usecase:
* "Demonstrate students enrolling/dropping in classes, and the notification to the chairperson when an enrollment
limit is reached. Also demonstrate the case when student is wait-listed and an opening occurs for that course."
* "The department also wants to know the students enrolled in a given course."
* "Provide the method, gpa, which computes the GPA of the student."
 * */

import faculty.FullTimeFaculty;
import program.ProgramFactory;
import student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EnrollmentTest {

    public static void main(String[] args) {

        // create a new CourseOffering based on a specification
        CourseOffering course1 = new CourseOffering(new CourseSpecification("Intro to Programming", 101,
                "A beginner's survey of Python", new FullTimeFaculty("Professor Louie")));

        System.out.println();

        // create 7 students
        System.out.println("--- Creating Students ---");
        List<Student> students = new ArrayList<>(Arrays.asList(
        new Student("Alice"),
        new Student("Tom"),
        new Student("Brad"),
        new Student("Jerry"),
        new Student("Sue"),
        new Student("Eggbert"),
        new Student("Maya")
                ));

        // enroll all students in undergrad CS degree program
        System.out.println("\n--- Enrolling Students in Degree Programs ---");
        for (Student student : students) {
            student.enrollInProgram(ProgramFactory.CS_UNDERGRAD.createProgram());
        }

        // attempt to register all 7 students for the class (2 will go on waitlist)
        System.out.println("\n--- Registering Students for Course ---");
        for (Student student : students) {
            course1.registerStudent(student);
            System.out.println();
        }

        // un-enroll student Sue. Eggbert will be notified and automatically enrolled
        System.out.println("--- A student drops course, triggering enrollment notification ---");
        course1.removeStudent(students.get(4));


        // show the students enrolled in this course using getStudentList()
        System.out.println("\n--- Students enrolled in " + course1 + " ---\n" + course1.getStudentList());

        System.out.println();

        // now the course is over, grades will be automatically assigned
        course1.finish();

        System.out.println("\n--- Showing grades ---");

        /* gpa() method can be invoked directly on the Student object, as shown here, or from the Transcript, as shown below.
        * GPA of -1 indicates that student has not yet completed any courses */
        for (Student student : students) {
            System.out.println(student.gpa());
            System.out.println();
        }

        System.out.println("--- Showing transcripts ---");

        /* The getTranscript() method internally invokes calculateGPA() as well */
        for (Student student: students) {
            student.getTranscript().print();
            System.out.println();
        }

    }


}

