package program.undergrad;

public class CISUndergrad extends Undergrad {

    public CISUndergrad() {
        // set required courses
        int[] requiredCourses = {111, 112, 113, 114, 115, 116, 117, 118, 119, 120};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Info Systems Undergraduate Degree Program");
    }

    @Override
    public String toString() {
        return "Computer Info Systems Undergraduate Degree Program";
    }

}
