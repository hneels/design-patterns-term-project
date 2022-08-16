package program.certificate;

public class SecurityCertificate extends Certificate {

    public SecurityCertificate() {
        // set required courses
        int[] requiredCourses = {501, 502, 503, 504};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Security Certificate Program");
    }

    @Override
    public String toString() {
        return "Security Certificate Program";
    }
}
