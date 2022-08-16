package query;

/* Facade pattern: this class acts as a facade for Students to send messages to advisors.
This class depends on many other classes across a complex subsystem including Chairman, FullTimeFaculty, Program,
Undergrad, Student, Thesis, and ThesisDatabase. It provides a cohesive, simple interface to the QueryTest class.
 */

import faculty.Chairman;
import faculty.FullTimeFaculty;
import program.Program;
import program.undergrad.Undergrad;
import student.Student;
import student.Thesis;
import student.ThesisDatabase;

public class Directory {

    // the student who owns this directory: instantiated in constructor
    private Student student;

    // chairman instance (a singleton)
    private Chairman chairman;


    /* requirement: "there is a single Graduate advisor and a single Undergraduate advisor"
        so the correct faculty member will always be returned to the Student through this Directory facade */
    private final FullTimeFaculty undergradAdvisor;
    private final FullTimeFaculty graduateAdvisor;


    // constructor saves the Student owner of this directory as a field
    public Directory(Student directoryOwner) {
        System.out.println("Creating a directory for " + directoryOwner);
        student = directoryOwner;
        chairman = Chairman.getInstance();
        undergradAdvisor = new FullTimeFaculty("Undergraduate Advisor Larry");
        graduateAdvisor = new FullTimeFaculty("Graduate Advisor Charles");
    }

    // getters for the program advisors
    public FullTimeFaculty getUndergradAdvisor() {
        return undergradAdvisor;
    }
    public FullTimeFaculty getGraduateAdvisor() {
        return graduateAdvisor;
    }

    // send message from the student who uses this directory to the chairman
    public void queryChairman(String message) {
        Query query = new Query(student, chairman);
        query.setMessage(message);
        query.send();
    }

    // send message from the student who uses this directory to their Thesis advisor
    public void queryThesisAdvisor(String message) {
        // get their thesis from the map
        Thesis thesis = ThesisDatabase.getThesis(student);

        // invalid if the student doesn't have a thesis
        if (thesis == null) {
            System.out.println("Student has no thesis advisor because they haven't started a thesis");
            return;
        }
        // if thesis exists, it must have an advisor because it's set in the Thesis constructor
        FullTimeFaculty advisor = thesis.getAdvisor();
        Query query = new Query(student, advisor);
        query.setMessage(message);
        query.send();
    }

    // send message from student to Graduate or Undergraduate Advisor (based on program)
    public void queryProgramAdvisor(String message) {
        Program program = student.getProgram();

        // if student is not enrolled, they have no advisor
        if (program == null) {
            System.out.println("Student is not enrolled and has no advisor");
            return;
        }

        // if student is a certificate student, they have no advisor
        if (!program.hasThesis()) {
            System.out.println("Certificate students do not have a program advisor");
            return;
        }

        Query query;
        // determine student's program type
        if (program instanceof Undergrad) {
            query = new Query(student, undergradAdvisor);

        } else {
            // must be a graduate student
            query = new Query(student, graduateAdvisor);
        }
        query.setMessage(message);
        query.send();
    }
}
