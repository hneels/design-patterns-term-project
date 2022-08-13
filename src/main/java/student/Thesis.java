package student;

import faculty.FullTimeFaculty;

public class Thesis {

    // the Student author of thesis
    Student student;

    // thesis will be assumed to be incomplete until marked complete
    private boolean complete = false;

    // full-time faculty serve as the thesis advisor
    public Thesis(Student student, FullTimeFaculty advisor) {
        // if the Student is enrolled in a Certificate program, they're not eligible to do a thesis
        if (! student.getProgram().hasThesis()) {
            throw new IllegalArgumentException(student + "'s program does not allow them to do a thesis.");
        }
        System.out.println(student + " is starting their thesis, advised by " + advisor);
        this.student = student;

        // always add new theses to the database for future access
        ThesisDatabase.addThesis(student, this);
    }

    // return whether thesis is finished
    public boolean isComplete() {
        return complete;
    }

    public void complete() {
        complete = true;
        System.out.println("Completing thesis by " + student);
    }
}
