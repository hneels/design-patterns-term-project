package program.undergrad;

public class CSUndergrad extends Undergrad {

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
