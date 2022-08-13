package course;

import faculty.Chairman;
import student.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* this class represents a specific instance of a course (as described by a CourseSpecification) offered during any
given semester */
public class CourseOffering {


    // has a CourseSpecification which describes it & contains information about teacher, syllabus, etc.
    private CourseSpecification specification;

    private final int enrollmentLimit = 5;


    /* observers: the Students must be Student rather than Observer instances because we need to interact with their transcripts.
        The updateAboutCourse() method, which is defined in Observer interface, is invoked on both students and chairman below. */
    private List<Student> studentList;
    private List<Student> waitList;

    // whether the course is over, or still in session
    private boolean finished;

    // constructor must take a CourseSpecification as the template for this course
    public CourseOffering(CourseSpecification courseSpecification) {
        this.specification = courseSpecification;
        this.finished = false;
        // initialize empty lists
        studentList = new ArrayList<>();
        waitList = new LinkedList<>(); // linked list better since we poll from front
        System.out.println("Created Course Offering: " + this);
    }

    // getters for both student Lists (used by faculty/ Chairman)
    public List<Student> getStudentList() {
        return studentList;
    }
    public List<Student> getWaitList() {
        return waitList;
    }

    // getter for associated Specification (the template/description for this course)
    public CourseSpecification getSpecification() {
        return specification;
    }

    /* Attempt to register a student for this session of the course. If the enrollment list is full, student
    will be placed on waitlist and Chairman will be notified */
    public void registerStudent(Student student) {
        // if there is space in the class, enroll student
        if (studentList.size() < enrollmentLimit) {
            System.out.println("Successfully registered student " + student + " for course " + this);
            studentList.add(student);
            // Observer pattern: notify student that they were enrolled
            student.updateAboutCourse(this);
            // also add a new record of this course to their transcript
            student.getTranscript().putRecord(this);
        } else {
            // from usecase: when the limit is reached, the Chairman will be notified automatically
            waitList.add(student);
            System.out.println("Student " + student + " added to waitlist for course " + this);
            // Observer pattern: notify the Chairman observer that limit is reached
            Chairman.getInstance().updateAboutCourse(this);
        }
    }

    /* remove a student from the waitList or enrollment list */
    public void removeStudent(Student student) {
        // no notifying needs to be done if student was on the waitlist
        if (waitList.contains(student)) {
            waitList.remove(student);
            System.out.println("Removed student " + student + " from waitlist");

            // if student was enrolled
        } else if (studentList.contains(student)) {
            studentList.remove(student);
            System.out.println("Removed student " + student + " from enrollment list");

            // also remove the record from that student's transcript
            student.getTranscript().deleteRecord(this);

            // now there is space to add the first Student on the waitlist. registerStudent() will trigger the Observer notification
            if (waitList.size() > 0) {
                registerStudent(waitList.remove(0));
            }
        } else {
            // if student was not in either list to begin with, cannot remove
            System.out.println(student + " was not registered for this course");
        }

    }

    // finish() will mark this course finished and assign grades to all enrolled students
    public void finish() {
        finished = true;
        System.out.println("Course " + this + " is finished. Assigning grades...");
        // give each student a grade
        for (Student student : studentList) {
            Random random = new Random();
            // from usecase, the following points are possible for grades: A (4), B (3), C (2), D (1), F(0), rounded to 2 places
            double randomGrade = Math.round((random.nextDouble() * 4) * 100.0) / 100.0;
            student.getTranscript().setGrade(this, randomGrade);
            // hopefully my course grade will not be generated with this algorithm :)
        }
    }

    @Override
    public String toString() {
        return getSpecification().toString();
    }


}
