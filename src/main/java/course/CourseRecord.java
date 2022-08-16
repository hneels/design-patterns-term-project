package course;

/* a CourseRecord is a record on the transcript of a student that has either enrolled in or completed a CourseOffering,
whereas a CourseSpecification is a general outline of a course including its title, course number, teacher, etc.
and a CourseOffering is an instance of a Course offered in any semester (in which students can drop/ enroll).

The Transcript class aggregates this class.

While a student is enrolled, the grade field will be -1 (to differentiate from a 0 received if a student
failed a course). Once the CourseOffering is marked finished, the grades will be updated from the CourseOffering class.
 */
public class CourseRecord {

    private final CourseOffering courseOffering;
    private double grade;

    public CourseRecord(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
        this.grade = -1;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        // if the course has not yet finished, show in-progress
        if (grade == -1) return courseOffering.getSpecification() + ", currently in-progress";
        // if the course is completed, show final grade
        return courseOffering.getSpecification() + ", final grade = " + grade;
    }

}
