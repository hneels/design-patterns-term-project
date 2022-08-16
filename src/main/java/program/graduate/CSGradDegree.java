package program.graduate;

public class CSGradDegree extends GradDegree {

    public CSGradDegree() {
        // set required courses
        int[] requiredCourses = {711, 712, 713, 714, 715, 716};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Science Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Computer Science Graduate Degree Program";
    }
}
