package faculty;

/* PartTimeFaculty class is a subclass of FacultyMember */

import course.ConcentrationComponent;

public class PartTimeFaculty extends FacultyMember {

    public PartTimeFaculty(String name) {
        super(name);
        // part-time faculty teach 1 course per semester
        setCourseLimit(1);
    }

    // part-time faculty may not coordinate a concentration
    @Override
    public void coordinate(ConcentrationComponent concentration) {
        System.out.println("Please try again. Part-time faculty may not coordinate a concentration.");
    }
}
