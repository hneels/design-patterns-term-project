package program.graduate;

public class CISGradDegree extends GradDegree {

    public CISGradDegree() {
        // set required courses
        int[] requiredCourses = {701, 702, 703, 704, 705, 706};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Info Systems Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Computer Info Systems Graduate Degree Program";
    }

}
