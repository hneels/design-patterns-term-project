package program.certificate;

public class AnalyticsCertificate extends Certificate {

    public AnalyticsCertificate() {
        // set required courses
        int[] requiredCourses = {401, 402, 403, 404};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Analytics Certificate Program");
    }

    @Override
    public String toString() {
        return "Analytics Certificate Program";
    }
}
