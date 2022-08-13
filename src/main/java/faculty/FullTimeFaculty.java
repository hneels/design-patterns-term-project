package faculty;

import course.Concentration;
import course.ConcentrationComponent;

public class FullTimeFaculty extends FacultyMember {

    // todo
    public FullTimeFaculty(String name) {
        super(name);
    }


    /* from usecase: "A full-time faculty member is responsible to coordinate each concentration (or sub-concentration).
    A full-time faculty member can be the coordinator for more than one concentration (or sub-concentration)."
    But only the chairman can coordinate top-level concentrations.
     */
    @Override
    public void coordinate(ConcentrationComponent concentration) {

        // check to see if this is a top-level concentration (with sub-concentrations)
        for (ConcentrationComponent child : concentration.getChildren()) {
            if (child instanceof Concentration) {
                System.out.println(this + " cannot coordinate a top-level Concentration");
                // the Chairman must coordinate it instead
                Chairman.getInstance().coordinate(concentration);
                return;
            }
        }
        // this concentration must have no sub-concentrations so a FullTimeFaculty may coordinate it
        System.out.println(this + " is coordinating " + concentration);

    }

}
