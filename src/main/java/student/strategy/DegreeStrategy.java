package student.strategy;

import program.Program;
import student.Student;
import student.Thesis;
import student.ThesisDatabase;
import student.Transcript;
import student.strategy.GraduationStrategy;

/* Strategy pattern: a degree-seeking student's eligibility is determined by both coursework and thesis */
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

        // check if student has completed the total number of courses required for the degree
        if (transcript.getCompletedCourseCount() < program.getTotalCourseNumber()) {
            System.out.println(student + " has not completed enough total courses");
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
