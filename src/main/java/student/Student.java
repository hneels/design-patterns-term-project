package student;

import course.CourseOffering;
import course.Observer;
import program.Program;
import query.Person;
import student.strategy.CertificateStrategy;
import student.strategy.DegreeStrategy;
import student.strategy.GraduationStrategy;

public class Student extends Person implements Observer {

    // the program will be null until the student enrolls
    private Program program;

    // the strategy for determining graduation eligibility is determined by the program they're enrolled in
    private GraduationStrategy graduationStrategy;

    // transcript will start empty and be updated by Observer pattern when they enroll in/ complete a course
    private final Transcript transcript;


    public Student(String name) {
        super(name);
        System.out.println("Creating student " + name);
        this.transcript = new Transcript(this);
    }

    // getter for Transcript (which is final)
    public Transcript getTranscript() {
        return transcript;
    }


    // enroll this student in a program
    public void enrollInProgram(Program program) {
        this.program = program;

        System.out.println("Enrolled student " + getName() + " in " + program);

        // if undergrad or graduate student, the graduation strategy must also take into account thesis completion
        if (program.hasThesis()) {
            this.graduationStrategy = new DegreeStrategy();

        } else {
            // if certificate-seeking student, the graduation strategy will only examine course completion
            this.graduationStrategy = new CertificateStrategy();
        }
    }

    /* strategy pattern: determining graduation eligibility is delegated to the Strategy algorithm, based on student's
    program type  */
    public boolean eligibleToGraduate() {
        return this.graduationStrategy.eligibleToGraduate(this);
    }

    // retrieve this student's current program
    public Program getProgram() {
        return this.program;
    }

    // student's GPA is calculated from within Transcript
    public double gpa() {
        return transcript.calculateGPA();
    }

    @Override
    public String toString() {
        return getName();
    }


    /* Observer Pattern: override from Observer interface to update student when they are moved off the waitlist for a course */
    @Override
    public void updateAboutCourse(CourseOffering courseOffering) {
        System.out.println("Student " + this + " notified that they have been enrolled in course " + courseOffering);

    }
}
