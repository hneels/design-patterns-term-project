package faculty;

import course.Concentration;
import course.ConcentrationComponent;

public abstract class FacultyMember {

    // TODO needs a list of current courses : initialized in constructor

    // TODO when a new CourseOffering is created, invoke addCourse on the teacher

    // TODO need addCourse, removeCourse, and showCourses method

    private String name;

    // subclasses will use this constructor with super() in their own constructor
    public FacultyMember(String name) {
        this.name = name;
    }

    // setter and getter for name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // the string representation is just this professor's name
    @Override
    public String toString() {
        return name;
    }

    /* from usecase: "A full-time faculty member is responsible to coordinate each concentration (or sub-concentration)."
    Each subclass PartTimeFaculty, FullTimeFaculty, and Chairman must implement this */
    public abstract void coordinate(ConcentrationComponent concentration);
}
