package program.certificate;

/* Certificate is a subclass of Program and a superclass of SecurityCertificate, WebCertificate, and AnalyticsCertificate */

import program.Program;

public abstract class Certificate extends Program {

    // no thesis is required to complete any certificate programs
    public boolean hasThesis() {
        return false;
    }

    // each certificate requires 4 total courses, all four of which are specified by the department (in subclass constructors)
    @Override
    public int getTotalCourseNumber() {
        return 4;
    }
}
