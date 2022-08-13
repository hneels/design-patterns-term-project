package query;


/* From usecase: "Students can send a query to their advisor as well as the Chairperson and any faculty."
This class encapsulates a query to/from a Student to/from a FacultyMember
 */
public class Query {

    private final Person sender;
    private final Person recipient;
    private String message;

    // constructor sets sender and receiver
    public Query(Person sender, Person recipient) {
        this.sender = sender;
        this.recipient = recipient;
        // message must be set with method below
        this.message = null;
        System.out.println("Creating query from " + sender + " to " + recipient);

    }

    // getters for properties
    public Person getSender() {
        return sender;
    }
    public Person getRecipient() {
        return recipient;
    }
    public String getMessage() {
        return message;
    }

    // create the body of the message
    public void setMessage(String message) {
        this.message = message;
        System.out.println("Adding message body '" + message + "' to query");
    }


    // ensure message body isn't empty before sending
    public void send() {
        if (message == null) {
            System.out.println("Cannot send query without a message body");
            return;
        }
        recipient.receiveMessage(this);
    }
}
