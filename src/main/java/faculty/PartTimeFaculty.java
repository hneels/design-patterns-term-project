package faculty;

import course.Concentration;
import course.ConcentrationComponent;

public class PartTimeFaculty extends FacultyMember {


    public PartTimeFaculty(String name) {
        super(name);
    }

    // part-time faculty may not coordinate a concentration
    @Override
    public void coordinate(ConcentrationComponent concentration) {
        System.out.println("Please try again. Part-time faculty may not coordinate a concentration.");
    }

    // todo

}
