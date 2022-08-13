package course;

/* Composite Pattern: Courses, Concentrations and Sub-Concentrations will implement this interface so that calling
* format() on any concentration will return and show the output for all sub-concentrations AND CourseSpecifications
* contained within it */

import java.util.List;

public abstract class ConcentrationComponent {

    // course or concentration title, e.g. "Software Design Patterns" or "Programming Languages"
    private final String title;

    // getter for title
    public String getTitle() {
        return title;
    }
    // constructor sets the title
    public ConcentrationComponent(String title) {
        this.title = title;
    }

    // toString shows the title
    @Override
    public String toString() {
        return title;
    }

    // leaf components and composite components must implement format() for the method to recursively print the tree
    public abstract String format();

    /* the composite subclass, Concentration, will override these three methods to make them add, remove,
    and return child components */
    public void add(ConcentrationComponent concentrationComponent) {
        throw new UnsupportedOperationException();
    };
    public void remove(ConcentrationComponent concentrationComponent) {
        throw new UnsupportedOperationException();
    };
    public List<ConcentrationComponent> getChildren() {
        throw new UnsupportedOperationException();
    }
}
