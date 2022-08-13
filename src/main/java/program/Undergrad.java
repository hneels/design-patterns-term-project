package program;

abstract class Undergrad extends Program {

    // a thesis is required to complete all undergraduate degree programs
    public boolean hasThesis() {
        return true;
    }

    // assume 20 courses are required for an undergrad degree, 10 of which are specified by the department (in constructors below)
    @Override
    public int getTotalCourseNumber() {
        return 20;
    }
}

class CSUndergrad extends Undergrad {

    public CSUndergrad() {
        // set required courses
        int[] requiredCourses = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Science Undergraduate Degree Program");
    }

    @Override
    public String toString() {
        return "Computer Science Undergraduate Degree Program";
    }

}

class CISUndergrad extends Undergrad {

    public CISUndergrad() {
        // set required courses
        int[] requiredCourses = {111, 112, 113, 114, 115, 116, 117, 118, 119, 120};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Info Systems Undergraduate Degree Program");
    }

    @Override
    public String toString() {
        return "Computer Info Systems Undergraduate Degree Program";
    }

}