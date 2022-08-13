package course;

/* A small syllabus class encapsulating the content of a syllabus. Each CourseSpecification must have a syllabus, but it can
be the default one (created with no-arg constructor). To get the Syllabus content from a CourseOffering, one must retrieve it from
the CourseOffering's CourseSpecification reference.
The syllabus is package-private and is only accessed through the CourseSpecification class. */

import faculty.FacultyMember;

class Syllabus {

    private final FacultyMember teacher;
    private String content;

    public Syllabus(FacultyMember teacher) {
        this.teacher = teacher;
        this.content = "A default syllabus";
    }

    public Syllabus(FacultyMember teacher, String content) {
        this.teacher = teacher;
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
