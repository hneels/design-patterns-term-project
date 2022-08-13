package student.strategy;

import program.Program;
import student.Student;

/* an algorithm to determine whether a student has completed program requirements and can graduate */
public interface GraduationStrategy {
    public boolean eligibleToGraduate(Student student);
}
