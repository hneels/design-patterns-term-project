package program;


abstract class Certificate extends Program {

    // no thesis is required to complete any certificate programs
    public boolean hasThesis() {
        return false;
    }

    // each certificate requires 4 total courses, all four of which are specified by the department (in constructors below)
    @Override
    public int getTotalCourseNumber() {
        return 4;
    }
}

class SecurityCertificate extends Certificate {

    public SecurityCertificate() {
        // set required coureses
        int[] requiredCourses = {501, 502, 503, 504};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Security Certificate Program");
    }

    @Override
    public String toString() {
        return "Security Certificate Program";
    }
}

class WebCertificate extends Certificate {

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

class AnalyticsCertificate extends Certificate {

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