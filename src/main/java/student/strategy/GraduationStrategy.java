package student.strategy;

/* Strategy pattern:
an algorithm to determine whether a student has completed program requirements and can graduate.
 This interface is implemented by CertificateStrategy and DegreeStrategy. */

import student.Student;

public interface GraduationStrategy {
    public boolean eligibleToGraduate(Student student);
}
