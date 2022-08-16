package query;

/* Test class for demonstrating Facade pattern, as well as requirements related to students sending queries,
 and getting their thesis / thesis advisors.
 */

import faculty.FullTimeFaculty;
import program.Program;
import program.ProgramFactory;
import program.graduate.CISGradDegree;
import program.undergrad.Undergrad;
import student.Student;
import student.Thesis;
import student.ThesisDatabase;

public class QueryTest {

    public static void main(String[] args) {

        // create new student and populate their data
        System.out.println("--- Populating student and thesis information ---");
        Student student = new Student("Jane");
        student.enrollInProgram(ProgramFactory.CIS_GRAD.createProgram());
        // AI-generated thesis title from https://www.aiweirdness.com/thesis-titles-generated-by-neural-18-01-11/
        Thesis thesis = new Thesis(student, new FullTimeFaculty("Professor Bob"),
                "Extreme polymer systems in policy and permanent markets");
        System.out.println("Information about this thesis:");
        System.out.println("Title: " + thesis.getTitle());
        System.out.println("Author: " + thesis.getStudent());
        System.out.println("Advisor: " + thesis.getAdvisor());
        // this directory is the facade class
        Directory directory = new Directory(student);


        // Part 1: send message to thesis advisor without Directory (not using the facade)
        System.out.println("\n--- Part 1: Sending a Thesis Advisor query without facade pattern ---");
        FullTimeFaculty thesisAdvisor = ThesisDatabase.getThesis(student).getAdvisor();
        Query query1 = new Query(student, thesisAdvisor);
        // cannot send without a message body
        query1.send();
        query1.setMessage("question about my thesis");
        // successfully send
        query1.send();


        // Part 2: Facade pattern: send the same message to thesis advisor with Directory method (more streamlined)
        System.out.println("\n--- Part 2: Sending a Thesis Advisor query using facade pattern ---");
        directory.queryThesisAdvisor("question about my thesis");


        // Part 3: send message to program advisor without the Directory methods (not using the facade)
        System.out.println("\n--- Sending a Program Advisor query without facade pattern ---");
        Program program = student.getProgram();
        FullTimeFaculty programAdvisor = null;
        if (program.hasThesis()) {
            if (program instanceof Undergrad) {
                programAdvisor = directory.getUndergradAdvisor();
            } else {
                programAdvisor = directory.getGraduateAdvisor();
            }
        } else {
            System.out.println("Student is not enrolled in a program with an advisor");
            return;
        }
        Query query2 = new Query(student, programAdvisor);
        query2.setMessage("question about my program");
        query2.send();


        // Part 4: Facade pattern: send the same message with a Directory method (much easier)
        System.out.println("\n--- Sending a Program Advisor query using facade pattern ---");
        directory.queryProgramAdvisor("question about my program");
    }
}
