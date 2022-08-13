package faculty;

/* this class demonstrates Singleton pattern: there is only one chairman of the department
at any time */

import course.ConcentrationComponent;
import course.CourseOffering;
import course.Observer;

public class Chairman extends FacultyMember implements Observer {

    private static Chairman uniqueInstance;

    // TODO courseload int ??

    // to implement the Singleton pattern, make the constructor private
    private Chairman(String name) {
        // TODO
        super(name);
    }

    // ... then provide static method that returns the single instance
    public static synchronized Chairman getInstance() {
        if (uniqueInstance == null) {
            // chairman hasn't been instantiated yet, so create unique instance
            uniqueInstance = new Chairman("Chairman Lou Chitkushev");
            System.out.println("Creating unique Chairman instance");
        }
        return uniqueInstance;
    }

    // the Chairman may coordinate any concentration or sub-concentration
    @Override
    public void coordinate(ConcentrationComponent concentration) {
        System.out.println(getName() + " is coordinating " + concentration);
    }

    /* Observer pattern: Chairman is updated when any course reaches enrollment limit. Overriding from Observer interface */
    @Override
    public void updateAboutCourse(CourseOffering courseOffering) {
        System.out.println(getName() + " is notified that " + courseOffering + " has reached limit with " +
                courseOffering.getWaitList().size() + " on waitlist");
    }
}
