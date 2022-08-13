package course;

/* a Specification (outline) for a course. Forms the template for a CourseOffering
* demonstrates Composite Pattern because this class extends ConcentrationComponent
* and overrides format() method */

import faculty.FacultyMember;


public class CourseSpecification extends ConcentrationComponent {

    // course catalog number, e.g. "665"
    private final int number;
    // a once-sentence description of the course
    private final String description;
    // per usecase description, a given course is taught by the same faculty member every time
    private final FacultyMember teacher;

    // the syllabus, may be default syllabus
    private Syllabus syllabus;

    // constructor sets all final variables
    public CourseSpecification(String title, int number, String description, FacultyMember teacher) {
        super(title);
        this.number = number;
        this.description = description;
        this.teacher = teacher;
        this.syllabus = new Syllabus(teacher); // default syllabus
    }

    public int getNumber() {
        return number;
    }
    public String getDescription() {
        return description;
    }
    public FacultyMember getTeacher() {
        return teacher;
    }

    /* The Syllabus is package-private and is accessed through this CourseSpecification class only */
    public String getSyllabus() {
        return this.syllabus.getContent();
    }
    public void setSyllabus(String content) {
        this.syllabus.setContent(content);
    }

    // Composite Pattern: returns an HTML format output of the course
    // since CourseSpecification is a leaf node, it doesn't have any children on which to invoke format()
    @Override
    public String format() {
        String output = "Showing HTML output of CS" +  this + description;
        System.out.println(output);
        return output;
    }

    // the superclass toString only shows the title, so create a fuller description with course number and teacher
    @Override
    public String toString() {
        return "CS" + number + ": " + getTitle() + " taught by " + teacher;
    }

}
