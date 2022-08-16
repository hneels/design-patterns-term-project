package faculty;

/* Test class to demonstrate Singleton pattern, as well as the functionality in Faculty package and
 usecase requirements for Faculty teaching schedules, including the following:
"A faculty member should easily know what courses they are teaching and the students they are advising."
"The Chairperson and the part time faculty teach only one course per semester, whereas
  the full time faculty teach three courses each semester." */

import course.CourseOffering;
import course.CourseSpecification;
import program.ProgramFactory;
import student.Student;
import student.Thesis;

public class FacultyTest {

    public static void main(String[] args) {

        // demonstrate Singleton
        Chairman chairman1 = Chairman.getInstance();
        Chairman chairman2 = Chairman.getInstance();

        System.out.println("Two invocations of Chairman.getInstance() return the same object?");
        System.out.println(chairman1 == chairman2);

        System.out.println();

        // demonstrate a Faculty teaching schedule and advisees

        FullTimeFaculty profBob = new FullTimeFaculty("Professor Bob");
        PartTimeFaculty profBill = new PartTimeFaculty("Professor Bill");

        // Full-time Professor Bob can teach 3 courses: the commented-out line will throw exception, until any of the in-progress courses are marked finished
        CourseOffering course601 = new CourseOffering(new CourseSpecification("course601", 601, "description of 601", profBob));
        CourseOffering course602 = new CourseOffering(new CourseSpecification("course602", 602, "description of 602", profBob));
        CourseOffering course603 = new CourseOffering(new CourseSpecification("course603", 603, "description of 603", profBob));
        // CourseOffering course604 = new CourseOffering(new CourseSpecification("course604", 604, "description of 604", profBob));

        System.out.println();

        // show Bob's course limit and current courses
        System.out.println("Professor Bob's max course load is " + profBob.getCourseLimit());
        profBob.showCourses();

        System.out.println();

        // show Bob's advisees
        Student janeStudent = new Student("Jane");
        janeStudent.enrollInProgram(ProgramFactory.CS_UNDERGRAD.createProgram());

        Student johnStudent = new Student("John");
        johnStudent.enrollInProgram(ProgramFactory.DA_GRAD.createProgram());

        // AI-generated thesis titles courtesy of https://www.aiweirdness.com/thesis-titles-generated-by-neural-18-01-11/
        Thesis thesis1 = new Thesis(janeStudent, profBob, "Privatization algorithms for meyout quaternion visibility motors");
        Thesis thesis2 = new Thesis(johnStudent, profBob, "Computational approaches for distributed microscopy");
        profBob.showAdvisees();

        System.out.println();

        // after Jane finishes her thesis, show Bob's advisees
        thesis1.complete();
        profBob.showAdvisees();

        System.out.println();

        // Part-time Professor Bill can teach 1 course (the commented-out line will throw exception)
        CourseOffering course711 = new CourseOffering(new CourseSpecification("course711", 711, "description of 711", profBill));
        // CourseOffering course712 = new CourseOffering(new CourseSpecification("course712", 712, "description of 712", profBill));

        // show Bill's course limit and current courses
        System.out.println("Professor Bill's max course load is " + profBill.getCourseLimit());
        profBill.showCourses();

        // Bill does not have showAdvisees() method because only FullTimeFaculty serve as thesis advisors






    }
}
