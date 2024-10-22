public class PagibigApp {
    public static void main(String[] args) {
        QueueManager queueManager = QueueManager.getInstance();

        // Creating users
        User user1 = queueManager.createUser("Alice");
        User user2 = queueManager.createUser("Bob");
        User user3 = queueManager.createUser("Charlie");

        // Display current queue in Pag-ibig
        System.out.println("Current queue in Pag-ibig starts at: " + 100);

        // Serve users
        queueManager.serveNextUser(); // Serving Alice
        queueManager.serveNextUser(); // Serving Bob
        queueManager.serveNextUser(); // Serving Charlie
        queueManager.serveNextUser(); // Attempt to serve when no users are left
    }
}