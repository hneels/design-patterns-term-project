package student;

/* Thesis objects aggregate to the ThesisDatabase and are automatically stored there upon creation.
* Any student in a Degree program must complete a thesis to graduate. */

import faculty.FullTimeFaculty;

public class Thesis {

    // the Student author of thesis
    private Student student;
    // the faculty advisor
    private FullTimeFaculty advisor;
    // the title of the thesis
    private String title;

    // thesis will be assumed to be incomplete until marked complete
    private boolean complete = false;

    // constructor sets the student, Full-Time Faculty advisor, and title
    public Thesis(Student student, FullTimeFaculty advisor, String title) {
        // if the Student is enrolled in a Certificate program, they're not eligible to do a thesis
        if (student.getProgram() == null || !student.getProgram().hasThesis()) {
            throw new IllegalArgumentException(student + "'s program does not allow them to do a thesis.");
        }
        this.student = student;
        this.advisor = advisor;
        this.title = title;

        System.out.println("Creating " + this);

        // always add new theses to the database for future access
        ThesisDatabase.addThesis(this);
    }

    // getter for student (cannot be changed)
    public Student getStudent() {
        return student;
    }

    // getter and setter for advisor
    public FullTimeFaculty getAdvisor() {
        return advisor;
    }
    public void setAdvisor(FullTimeFaculty advisor) {
        this.advisor = advisor;
    }

    // getter and setter for title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // return whether thesis is finished
    public boolean isComplete() {
        return complete;
    }

    // if the thesis is complete, mark it as complete and also remove the advisor
    public void complete() {
        complete = true;
        ThesisDatabase.removeAdvisee(advisor, student);
        System.out.println("Completing " + this);
    }

    @Override
    public String toString() {
        return "Thesis by " + student + " about '" + title + "' advised by " + advisor;
    }
}
