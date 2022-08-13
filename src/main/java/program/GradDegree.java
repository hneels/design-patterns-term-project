package program;

abstract class GradDegree extends Program {

    // a thesis is required to complete all graduate degree programs
    public boolean hasThesis() {
        return true;
    }

    // assume 10 courses are required for graduate degree, 6 of which are determined by department (in constructors below)
    @Override
    public int getTotalCourseNumber() {
        return 10;
    }
}

class CISGradDegree extends GradDegree {

    public CISGradDegree() {
        // set required courses
        int[] requiredCourses = {701, 702, 703, 704, 705, 706};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Info Systems Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Computer Info Systems Graduate Degree Program";
    }

}

class CSGradDegree extends GradDegree {

    public CSGradDegree() {
        // set required courses
        int[] requiredCourses = {711, 712, 713, 714, 715, 716};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Computer Science Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Computer Science Graduate Degree Program";
    }
}

class DAGradDegree extends GradDegree {

    public DAGradDegree() {
        // set required courses
        int[] requiredCourses = {401, 402, 403, 404, 405, 406};
        setRequiredCourses(requiredCourses);
        System.out.println("Creating new Data Analytics Graduate Degree program");
    }

    @Override
    public String toString() {
        return "Data Analytics Graduate Degree Program";
    }


}