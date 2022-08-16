package faculty;

/* FullTimeFaculty is a subclass of FacultyMember */

import course.Concentration;
import course.ConcentrationComponent;
import student.Student;
import student.ThesisDatabase;

import java.util.List;

public class FullTimeFaculty extends FacultyMember {

    public FullTimeFaculty(String name) {
        super(name);
        // full-time faculty teach 3 courses per semester
        setCourseLimit(3);
    }

    /* requirement: "A full-time faculty member is responsible to coordinate each concentration (or sub-concentration).
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

    /* requirement: "a faculty member should know the students they are advising"
    use ThesisDatabase to easily retrieve this information
     */
    public void showAdvisees() {
        List<Student> adviseeList = ThesisDatabase.getAdvisees(this);
        if (adviseeList != null && adviseeList.size() > 0) {
            System.out.println(this + " advises the following students: " + adviseeList);
        } else {
            System.out.println(this + " currently has no student advisees");
        }
    }

}
