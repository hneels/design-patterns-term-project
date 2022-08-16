package program;

/* Program is the superclass of all Certificate, Undergrad, and Graduate programs */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Program {


    // the required courses for each program are represented as a list of their course numbers
    List<Integer> requiredCourses;

    // abstract subclasses Certificate, Undergrad, and GradDegree will implement these two methods
    public abstract boolean hasThesis();
    public abstract int getTotalCourseNumber();

    public List<Integer> getRequiredCourses() {
        return requiredCourses;
    }

    // concrete subclasses will set the required course list in their constructors
    protected void setRequiredCourses(int[] courseNumbers) {
        requiredCourses = Arrays.stream(courseNumbers).boxed().collect(Collectors.toList());
    }

}


