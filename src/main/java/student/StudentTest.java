package student;

/* This test class demonstrates output from Strategy and Factory patterns, as well as the following requirements for Student package:

* Each program requires a fixed number of core courses (determined by the department) and fixed number of elective courses
(the student picks the electives from the choices particular to the program).
* For both degree programs, students must complete a thesis to graduate. Certificate students do not do a thesis.
* Students can graduate whenever the program requirements are met.
* The department can check which courses a student has enrolled in by printing their transcript.
*
 *  */

import course.CourseOffering;
import course.CourseSpecification;
import faculty.FacultyMember;
import faculty.FullTimeFaculty;
import program.ProgramFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    public static void main(String[] args) {

        // Student Alice enrolls in Web Certificate program
        System.out.println("\n--- Alice enrolls in Web Certificate program and tries to graduate ---");
        Student alice = new Student("Alice");
        // use Factory to create Alice's certificate program
        alice.enrollInProgram(ProgramFactory.WEB_CERT.createProgram());
        // test graduation Strategy
        alice.eligibleToGraduate();


        // complete coursework and test graduation Strategy again
        // required course for Alice's program: [601, 602, 603, 604], no electives required
        System.out.println("\n--- Alice enrolls in courses required for her program ---");
        FacultyMember prof1 = new FullTimeFaculty("Professor 1");
        FacultyMember prof2 = new FullTimeFaculty("Professor 2");
        List<CourseOffering> courseList = new ArrayList<>();
        // create the courses
        CourseOffering course601 = new CourseOffering(new CourseSpecification("course601", 601, "description of 601", prof1));
        courseList.add(course601);
        CourseOffering course602 = new CourseOffering(new CourseSpecification("course602", 602, "description of 602", prof1));
        courseList.add(course602);
        CourseOffering course603 = new CourseOffering(new CourseSpecification("course603", 603, "description of 603", prof1));
        courseList.add(course603);
        CourseOffering course604 = new CourseOffering(new CourseSpecification("course604", 604, "description of 604", prof2));
        courseList.add(course604);

        // enroll Alice in each course and then finish the courses so grades are assigned to Alice's transcript
        for (CourseOffering course : courseList) {
            course.registerStudent(alice);
            course.finish();
        }

        // now Alice has completed all courses for her program and is eligible to graduate
        System.out.println("\n--- Now that she's completed program requirements, Alice tries again to graduate ---");
        alice.eligibleToGraduate();
        System.out.println();
        alice.getTranscript().print();


        // student Bob enrolls in Computer Science graduate program
        System.out.println("\n--- Bob enrolls in CS Graduate Degree program and tries to graduate ---");
        Student bob = new Student("Bob");
        // use Factory to create Bob's degree program
        bob.enrollInProgram(ProgramFactory.CS_GRAD.createProgram());
        // test graduation Strategy before starting program requirements (not eligible)
        bob.eligibleToGraduate();



        /* Bob must complete required courses for CSGrad program AND sufficient electives:
        courses [711, 712, 713, 714, 715, 716] are core courses for the degree, but 10 total courses must be completed including electives
         */
        System.out.println("\n--- Bob enrolls in courses required for his program ---");

        courseList = new ArrayList<>();

        // six core courses
        CourseOffering course711 = new CourseOffering(
                new CourseSpecification("course711", 711, "description of 711", new FullTimeFaculty("Professor for 711")));
        courseList.add(course711);
        CourseOffering course712 = new CourseOffering(
                new CourseSpecification("course712", 712, "description of 712", new FullTimeFaculty("Professor for 712")));
        courseList.add(course712);
        CourseOffering course713 = new CourseOffering(
                new CourseSpecification("course713", 713, "description of 713", new FullTimeFaculty("Professor for 713")));
        courseList.add(course713);
        CourseOffering course714 = new CourseOffering(
                new CourseSpecification("course714", 714, "description of 714", new FullTimeFaculty("Professor for 714")));
        courseList.add(course714);
        CourseOffering course715 = new CourseOffering(
                new CourseSpecification("course715", 715, "description of 715", new FullTimeFaculty("Professor for 715")));
        courseList.add(course715);
        CourseOffering course716 = new CourseOffering(
                new CourseSpecification("course716", 716, "description of 716", new FullTimeFaculty("Professor for 716")));
        courseList.add(course716);


        // four electives
        CourseOffering course800 = new CourseOffering(
                new CourseSpecification("course800", 800, "description of 714", new FullTimeFaculty("Professor for 800")));
        courseList.add(course800);
        CourseOffering course801 = new CourseOffering(
                new CourseSpecification("course801", 801, "description of 801", new FullTimeFaculty("Professor for 801")));
        courseList.add(course801);
        CourseOffering course802 = new CourseOffering(
                new CourseSpecification("course802", 802, "description of 802", new FullTimeFaculty("Professor for 802")));
        courseList.add(course802);
        CourseOffering course803 = new CourseOffering(
                new CourseSpecification("course803", 803, "description of 803", new FullTimeFaculty("Professor for 803")));
        courseList.add(course803);

        // enroll in and finish all his courses so grades are marked in his transcript
        for (CourseOffering course : courseList) {
            course.registerStudent(bob);
            course.finish();
        }

        // test graduation strategy: Bob has completed all core courses and electives, but he still needs to do a thesis
        System.out.println("\n--- Now that he's finished his courses, Bob tries again to graduate ---");
        bob.eligibleToGraduate();


        /* Bob must start a thesis since he's a degree-seeking student.
        Title from https://www.aiweirdness.com/thesis-titles-generated-by-neural-18-01-11/  */
        System.out.println("\n--- Bob starts and completes his thesis ---");
        Thesis bobThesis = new Thesis(bob, new FullTimeFaculty("Professor Jane"), "Atoms and characteristics of monolithic nanocity");
        bobThesis.complete();

        // test graduation Strategy again after core courses, electives, and thesis have been completed
        System.out.println("\n--- Bob tries to graduate one final time ---");
        bob.eligibleToGraduate();

        System.out.println();

        bob.getTranscript().print();


    }
}
