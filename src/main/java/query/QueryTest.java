package query;

import faculty.FullTimeFaculty;
import student.Student;

public class QueryTest {

    public static void main(String[] args) {

        // create new student
        Student student = new Student("Jane");
        FullTimeFaculty professor = new FullTimeFaculty("Professor Bob");

        // test student sending a query directly to a professor
        Query query = new Query(student, professor);
        // cannot send without a message body
        query.send();
        query.setMessage("hello");
        // successfully send
        query.send();

        // test student using Directory facade
    }
}
