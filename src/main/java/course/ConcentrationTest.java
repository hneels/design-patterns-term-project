package course;

/* class for testing the course package and related functionality */

import faculty.FacultyMember;
import faculty.FullTimeFaculty;
import faculty.PartTimeFaculty;

public class ConcentrationTest {

    public static void main(String[] args) {

        // a teacher
        FacultyMember professorBob = new FullTimeFaculty("Professor Bob");

        // a top-level concentration
        ConcentrationComponent languagesConcentration = new Concentration("Programming Languages Concentration");

        // a sub-concentration
        ConcentrationComponent oopSubConcentration = new Concentration("Object-Oriented Languages Sub-concentration");

        // three courses
        CourseSpecification javaCourse1 = new CourseSpecification("Info Structures in Java", 520,
                "An introduction to programming in Java", professorBob);
        CourseSpecification javaCourse2 = new CourseSpecification("Data Structures & Algorithms in Java", 526,
                "A survey of algorithms and data structures", professorBob);
        CourseSpecification javascriptCourse1 = new CourseSpecification("Intro to JavaScript", 123,
                "An introduction to programming in JavaScript", professorBob);

        // add courses to Object-Oriented Languages sub-concentration
        oopSubConcentration.add(javaCourse1);
        oopSubConcentration.add(javaCourse2);
        oopSubConcentration.add(javascriptCourse1);

        // add Object-Oriented Languages sub-concentration to the Programming Languages top-level concentration
        languagesConcentration.add(oopSubConcentration);


        /* demonstrate Composite Pattern with format()
        "output" contains the output for the whole tree, but output is also printed within the format() invocations
        so it doesn't need to be printed here */
        System.out.println("\n--- Testing format() of concentrations, sub-concentrations, and courses ---");
        String output = languagesConcentration.format();

        System.out.println();


        // test Faculty Members coordinating the Concentrations and sub-concentrations
        System.out.println("--- Testing faculty members coordinating different concentrations ---");


        System.out.println("\nFull-time faculty attempts to coordinate top-level concentration...");
        professorBob.coordinate(languagesConcentration);

        System.out.println("\nFull-time faculty attempts to coordinate sub-concentration...");
        professorBob.coordinate(oopSubConcentration);


        System.out.println("\nPart-time faculty attempts to coordinate top-level concentration...");
        FacultyMember charlieProfessor = new PartTimeFaculty("Professor Charlie");
        charlieProfessor.coordinate(oopSubConcentration);

    }
}
