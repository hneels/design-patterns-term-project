package program.graduate;

/* GradDegree is a subclass of Program and a superclass of CISGradDegree, CSGradDegree, and DAGradDegree */

import program.Program;

public abstract class GradDegree extends Program {

    // a thesis is required to complete all graduate degree programs
    public boolean hasThesis() {
        return true;
    }

    // assume 10 courses are required for graduate degree, 6 of which are determined by department (in subclass constructors)
    @Override
    public int getTotalCourseNumber() {
        return 10;
    }
}
