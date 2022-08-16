package course;

/* a top-level Concentration. May contain only CourseSpecifications if the concentration is small, or may contain
sub-concentrations if it's a wide one */


import java.util.ArrayList;
import java.util.List;

public class Concentration extends ConcentrationComponent {

    // maintains a list of its children. These can be CourseSpecifications (leaf nodes) or Concentrations (composite nodes)
    List<ConcentrationComponent> children;

    // constructor initializes an empty child list
    public Concentration(String title) {
        super(title);
        children = new ArrayList<>();
    }

    //* add, remove, or return children from this Concentration's child list */
    @Override
    public void add(ConcentrationComponent child) {
        children.add(child);
    }
    @Override
    public void remove(ConcentrationComponent child) {
        children.remove(child);
    }
    @Override
    public List<ConcentrationComponent> getChildren() {
        return this.children;
    }


    // first get output for THIS concentration, then recursively call format() on all children (CourseSpecifications or sub- Concentrations)
    @Override
    public String format() {
        String output = "Showing HTML output of " + getTitle();
        System.out.println(output);
        // invoke format() on all child courses or concentrations
        for (ConcentrationComponent child : children) {
            output +=  "\n" + child.format();
        }
        return output;
    }

}
