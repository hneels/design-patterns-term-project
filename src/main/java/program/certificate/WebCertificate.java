package program.certificate;

public class WebCertificate extends Certificate {

    public WebCertificate() {
        // set required courses
        int[] requiredCourses = {601, 602, 603, 604};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Web Technology Certificate Program");
    }

    @Override
    public String toString() {
        return "Web Technology Certificate Program";
    }
}
