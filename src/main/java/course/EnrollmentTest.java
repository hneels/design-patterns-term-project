package course;

import faculty.Chairman;
import faculty.FullTimeFaculty;
import student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* this class tests the Enrollment features and the Observer pattern */

public class EnrollmentTest {

    public static void main(String[] args) {

        // create a new CourseOffering
        CourseOffering course1 = new CourseOffering(new CourseSpecification("Intro to Programming", 101,
                "A beginner's survey of Python", new FullTimeFaculty("Louie")));

        // create 7 students
        List<Student> students = new ArrayList<>(Arrays.asList(
        new Student("Alice"),
        new Student("Tom"),
        new Student("Brad"),
        new Student("Jerry"),
        new Student("Sue"),
        new Student("Eggbert"),
        new Student("Maya")
                ));

        // attempt to enroll all 5 students (2 will go on waitlist)
        for (Student student : students) {
            course1.registerStudent(student);
        }

        // un-enroll student Sue: Eggbert will be notified and automatically enrolled
        course1.removeStudent(students.get(4));

        // now the course is over. grades will be automatically assigned
        course1.finish();

        for (Student student : students) {
            System.out.println(student.gpa());
        }

        for (Student student: students) {
            student.getTranscript().print();
        }

    }


}

