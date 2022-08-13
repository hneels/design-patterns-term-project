package student;

/* Test class to demonstrate functionality in Student package */
import faculty.FullTimeFaculty;
import program.ProgramFactory;

public class StudentTest {

    public static void main(String[] args) {

        // Student Alice enrolls in Web Certificate program
        System.out.println("\n--Testing student enrolling in program--");
        Student alice = new Student("Alice");
        // use Factory to create Alice's certificate program
        alice.enrollInProgram(ProgramFactory.WEB_CERT.createProgram());
        // test graduation Strategy
        alice.eligibleToGraduate();

        System.out.println();

        // student Bob enrolls in Computer Science graduate program
        Student bob = new Student("Bob");
        // use Factory to create Bob's degree program
        bob.enrollInProgram(ProgramFactory.CS_GRAD.createProgram());
        // test graduation Strategy before starting thesis
        bob.eligibleToGraduate();
        // Bob can start a thesis since he's a degree-seeking student
        Thesis bobThesis = new Thesis(bob, new FullTimeFaculty("Professor Jane"));
        bobThesis.complete();
        // test graduation Strategy again after requirements have been met
        bob.eligibleToGraduate();

        // TODO test students when they have completed degree requirements: how?


    }
}
