package program.undergrad;

/* Undergrad is a subclass of Program and a superclass of CISUndergrad and CSUndergrad */

import program.Program;

public abstract class Undergrad extends Program {

    // a thesis is required to complete all undergraduate degree programs
    public boolean hasThesis() {
        return true;
    }

    // assume 20 courses are required for an undergrad degree, 10 of which are specified by the department (in subclass constructors)
    @Override
    public int getTotalCourseNumber() {
        return 20;
    }
}

