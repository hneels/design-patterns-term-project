package student.strategy;

/* Strategy pattern: the algorithm for determining a degree-seeking student's eligibility to graduate is determined by
core coursework completion (required by their specific degree program), elective completion, and thesis completion */

import program.Program;
import student.Student;
import student.Thesis;
import student.ThesisDatabase;
import student.Transcript;

public class DegreeStrategy implements GraduationStrategy {

    @Override
    public boolean eligibleToGraduate(Student student) {

        System.out.println("Evaluating graduation eligibility based on degree-seeking student (with thesis)");

        // get program and make sure they're enrolled
        Program program = student.getProgram();

        if (program == null) {
            System.out.println(student + " is not even enrolled in a program");
            return false;
        }

        Transcript transcript = student.getTranscript();

        // check if student has completed the total number of courses required for the degree, including electives
        System.out.println("Checking if enough electives are completed...");
        int programCourses = program.getTotalCourseNumber();
        if (transcript.getCompletedCourseCount() < programCourses) {
            System.out.println(student + " has not completed " + programCourses +" courses");
            return false;
        }

        // check each core course required by the department against the CourseRecords in the Transcript
        for (int requiredCourse : program.getRequiredCourses()) {
            if (transcript.getRecord(requiredCourse) == null) {
                System.out.println(student + " has not completed all core courses required for the degree");
                return false;
            }
        }

        // check ThesisDatabase to see if this student's thesis exists AND is completed
        Thesis thesis = ThesisDatabase.getThesis(student);
        if (thesis == null || !thesis.isComplete()) {
            System.out.println(student + " has not completed thesis and cannot graduate");
            return false;

        }
        // degree student has completed required core courses, total overall credits including electives, and thesis
        System.out.println(student + " completed degree requirements and is eligible to graduate");
        return true;

    }
}
