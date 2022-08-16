package query;

/* The Person class encapsulates the functionality for receiving messages ("queries"). Since all methods are fully defined,
other "person" classes (FacultyMember and Student) can extend this with no overrides needed to be able to receive queries.

Student and FacultyMember both extend this class.

Chose to include it in this package because its core behavior is related to queries.

 */
public abstract class Person {

    private final String name;

    // constructor sets the name, subclasses will call super(name) from their constructor
    public Person(String name) {
        this.name = name;
    }

    // getter for final field name
    public String getName() {
        return name;
    }

    // receive a query
    public void receiveMessage(Query query) {
        System.out.println(name + " received message '" + query.getMessage() + "' from " + query.getSender());
    }
}
