package student;

/* A Transcript is a record of all courses a Student has enrolled in and/or completed. Every Student has a Transcript
automatically instantiated by its constructor.

The Transcript aggregates CourseRecord instances, each of which encapsulates information about the course taken and grade received.

 */

import course.CourseOffering;
import course.CourseRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Transcript {

    private final Student student;

    /* Map of all courses either completed (with grade between 0-4) or currently enrolled (grade is -1, indicating in-progress)
    * the key is the course number and the value is the CourseRecord*/
    Map<Integer, CourseRecord> recordMap;

    // constructor must have student
    public Transcript(Student student) {
        this.student = student;
        this.recordMap  = new HashMap<>();
    }

    // get the total number of courses the student has completed
    public int getCompletedCourseCount() {
        // retrieve all map entries that have a completed grade (not -1)
        List<CourseRecord> completedCourses = recordMap.values().stream()
                .filter(record -> record.getGrade() >= 0).collect(Collectors.toList());
        return completedCourses.size();
    }

    // retrieve a CourseRecord from this transcript by the course's number
    public CourseRecord getRecord(int courseNum) {
        System.out.println("Searching for course number " + courseNum + " in " + student + "'s transcript");
        return recordMap.get(courseNum);
    }

    // put a new CourseRecord into the recordMap
    public void putRecord(CourseOffering courseOffering) {
        int courseNum = courseOffering.getSpecification().getNumber();
        // create a NEW record in the transcript based on the specific CourseOffering
        recordMap.put(courseNum, new CourseRecord(courseOffering));
        System.out.println("Adding course " + courseOffering + " to " + student + "'s transcript");
    }

    /* remove a CourseRecord from the map (such as if a student drops a class before the deadline).
    this method is invoked within CourseOffering when a student withdraws from the enrollment list */
    public void deleteRecord(CourseOffering courseOffering) {
        int courseNum = courseOffering.getSpecification().getNumber();
        recordMap.remove(courseNum);
        System.out.println("Removing course " + courseOffering + " from " + student + "'s transcript");
    }

    public void setGrade(CourseOffering courseOffering, double grade) {
        int courseNum = courseOffering.getSpecification().getNumber();
        // if that course doesn't already exist in the transcript map, create a new record first
        if (getRecord(courseNum) == null) {
            putRecord(courseOffering);
        }
        // update the grade
        recordMap.get(courseNum).setGrade(grade);
        System.out.println("Set grade in " + student + "'s transcript: grade " + grade +" in course " + courseOffering);
    }

    // print the transcript to console, including coursework, program, and gpa
    public void print() {

        double gpa = calculateGPA();

        // if no classes on record, print message
        if (recordMap.size() == 0) {
            System.out.println("*** " + student +"'s transcript for " + student.getProgram() + ". No GPA ***");
            System.out.println("No classes finished yet");
            return;
        }
        // if student has taken classes, iterate through map
        System.out.println("*** " + student +"'s transcript for " + student.getProgram() + " with GPA " + gpa + " ***");
        for (int courseNum : recordMap.keySet()) {
            // use toString provided by CourseRecord
            System.out.println(recordMap.get(courseNum));
        }
    }

    // calculate the GPA (used by Student gpa() method)
    public double calculateGPA() {

        // only include grades for completed courses
        int completedCourses = 0;
        double gradeSum = 0;
        for (CourseRecord record : recordMap.values()) {
            // -1 indicates course is still in session and no grade has been recorded
            if (record.getGrade() != -1) {
                completedCourses++;
                gradeSum += record.getGrade();
            }
        }
        // don't divide by 0: if completedCourses is 0, there's no GPA yet
        if (completedCourses == 0) {
            System.out.println("Calculating GPA for " + student + "... no grades yet");
            return -1;
        }
        // return the average of all completed courses, rounded to 2 places
        double grade = Math.round((gradeSum / completedCourses) * 100.0) / 100.0;
        System.out.println("Calculating GPA for " + student + ": " + grade);
        return grade;
    }
}
