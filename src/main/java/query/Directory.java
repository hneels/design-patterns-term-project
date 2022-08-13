package query;

import faculty.Chairman;
import faculty.FullTimeFaculty;
import student.Student;

/* Facade pattern: this class acts as a facade for the Student class to send messages to faculty
This class accesses the ThesisDatabase, Query, Chairman, FacultyMember, .... what other classes?
 */
public class Directory {

    // the student who owns this directory -- instantiated in constructor
    private Student student;

    // chairman instance (a singleton)
    private Chairman chairman;

    /* from usecase, "there is a single Graduate advisor and a single Undergraduate advisor"
    so the correct faculty member will always be returned to the Student through this Directory facade */
    private final FullTimeFaculty undergradAdvisor;
    private final FullTimeFaculty graduateAdvisor;


    public Directory(Student directoryOwner) {
        student = directoryOwner;
        chairman = Chairman.getInstance();
        undergradAdvisor = new FullTimeFaculty("Undergraduate Advisor Larry");
        graduateAdvisor = new FullTimeFaculty("Graduate Advisor Charles");
    }

    // method: send message to chairman
    public void queryChairman(String message) {


    }


    // method: send message to Thesis advisor

    // method: send message to Graduate or Undergraduate Advisor (based on program)

    // method: send message to another FacultyMember

    // method: lookupFacultyByName(String)

    // the method for sending a message to another faculty member will take that faculty member object and the message
}
