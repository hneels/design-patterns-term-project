package program.graduate;

public class DAGradDegree extends GradDegree {

    public DAGradDegree() {
        // set required courses
        int[] requiredCourses = {401, 402, 403, 404, 405, 406};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Data Analytics Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Data Analytics Graduate Degree Program";
    }


}
