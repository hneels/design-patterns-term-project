package faculty;

import course.ConcentrationComponent;
import query.Person;

public abstract class FacultyMember extends Person {

    // TODO needs a list of current courses : initialized in constructor

    // TODO when a new CourseOffering is created, invoke addCourse on the teacher

    // TODO need addCourse, removeCourse, and showCourses method


    // subclasses will use this constructor with super() in their own constructor
    public FacultyMember(String name) {
        super(name);
    }

    // the string representation is just this professor's name
    @Override
    public String toString() {
        return getName();
    }

    /* from usecase: "A full-time faculty member is responsible to coordinate each concentration (or sub-concentration)."
    Each subclass PartTimeFaculty, FullTimeFaculty, and Chairman must implement this */
    public abstract void coordinate(ConcentrationComponent concentration);
}
