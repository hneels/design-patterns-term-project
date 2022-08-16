package student.strategy;

/* Strategy pattern: a certificate-seeking student's eligibility is determined by coursework completion only.
* The algorithm for determining a Certificate-program student's graduation eligibility is encapsulated in this class  */

import program.Program;
import student.Student;
import student.Transcript;

import java.util.List;

public class CertificateStrategy implements GraduationStrategy {

    @Override
    public boolean eligibleToGraduate(Student student) {

        System.out.println("Evaluating graduation eligibility based on certificate-seeking student (no thesis)");

        // get program and make sure they're enrolled
        Program program = student.getProgram();

        if (program == null) {
            System.out.println(student + " is not even enrolled in a program");
            return false;
        }

        // compare student's transcript to their program
        List<Integer> requiredCourses = student.getProgram().getRequiredCourses();
        Transcript transcript = student.getTranscript();

        // check each required course (int) against the CourseRecords in the Transcript
        for (int requiredCourse : requiredCourses) {
            if (transcript.getRecord(requiredCourse) == null) {
                System.out.println(student + " has not completed all 4 required courses for certificate");
                return false;
            }
        }
        // each course required by Program was found in student's transcript
        System.out.println(student + " completed all 4 courses required for certificate and can graduate");
        return true;
    }
}
