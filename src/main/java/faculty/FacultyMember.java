package faculty;

/* FacultyMember is the superclass of FullTimeFaculty, PartTimeFaculty, and Chairman */

import course.ConcentrationComponent;
import course.CourseOffering;
import query.Person;

import java.util.ArrayList;
import java.util.List;


public abstract class FacultyMember extends Person {

    // a list of courses they are currently teaching (in any given semester)
    private List<CourseOffering> currentCourses;

    // the limit of courses they can teach (set by subclasses)
    private int courseLimit;

    // subclasses will use this constructor with super() in their own constructor
    public FacultyMember(String name) {
        super(name);
        currentCourses = new ArrayList<>();
    }

    // getter and setter for course limit
    public int getCourseLimit() {
        return courseLimit;
    }
    public void setCourseLimit(int courseLimit) {
        this.courseLimit = courseLimit;
    }


    // addCourse ensures that this FacultyMember hasn't exceeded their course limit
    public void addCourse(CourseOffering course) {
        if (currentCourses.size() < courseLimit) {
            System.out.println("Adding " + course + " to " + getName() + "'s schedule");
            this.currentCourses.add(course);
        } else {
            throw new IllegalArgumentException(getName() + " has reached course limit");
        }
    }

    // Remove a course from this professor's current course list. This method is invoked from CourseOffering's finish() method
    public void removeCourse(CourseOffering course) {
        System.out.println("Removing " + course + " from " + getName() + "'s schedule");
        this.currentCourses.remove(course);
    }

    // remove all courses from this professor's current course list
    public void resetCourses() {
        System.out.println("Clearing " + getName() + "'s course load");
        currentCourses = new ArrayList<>();
    }

    /* requirement: "a faculty member should easily know what courses they are teaching"
    When new CourseOfferings are created, they are automatically added to the professor's course list, and when
    courses are marked finished and grades are assigned, they are automatically removed from the professor's course list.
    (This is done from within the CourseOffering methods. */
    public void showCourses() {
        System.out.println(this + "'s current courses: " + currentCourses);
    }

    // the string representation is just this professor's name
    @Override
    public String toString() {
        return getName();
    }

    /* requirement: "A full-time faculty member is responsible to coordinate each concentration (or sub-concentration)."
    Each subclass PartTimeFaculty, FullTimeFaculty, and Chairman must implement this */
    public abstract void coordinate(ConcentrationComponent concentration);


}
