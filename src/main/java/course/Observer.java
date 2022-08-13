package course;

/* Observer pattern: Student and Chairman classes both implement this interface to receive notifications about changes
in state in the CourseOffering class */
public interface Observer {

    public void updateAboutCourse(CourseOffering courseOffering);
}

