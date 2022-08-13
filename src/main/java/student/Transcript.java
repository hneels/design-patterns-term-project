package student;

import course.CourseOffering;
import course.CourseRecord;

import java.util.ArrayList;
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
        System.out.println("Searching for course number " + courseNum + " in transcript");
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

    // print the transcript to console
    public void print() {
        System.out.println("\n--- Printing " + student +" 's Transcript ---");
        // if no classes on record, print message
        if (recordMap.size() == 0) {
            System.out.println("No classes yet");
            return;
        }
        // if student has taken classes, iterate through map
        for (int courseNum : recordMap.keySet()) {
            // use toString provided by CourseRecord
            System.out.println(recordMap.get(courseNum));
        }
    }

    // calculate the GPA (used by student gpa() method)
    public double calculateGPA() {
        System.out.println("Calculating GPA for " + student);

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
        if (completedCourses == 0) return -1;
        // return the average of all completed courses, rounded to 2 places
        double grade = Math.round((gradeSum / completedCourses) * 100.0) / 100.0;
        return grade;
    }
}
