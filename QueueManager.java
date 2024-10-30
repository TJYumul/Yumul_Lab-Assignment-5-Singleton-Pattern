import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private static QueueManager instance;
    private int currentQueueNumber = 70;
    private final Queue<User> users = new LinkedList<>();

    private QueueManager() {

    }

    public static synchronized QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

    public synchronized void addUser(String name) {
        User user = new User(name, currentQueueNumber++);
        users.add(user);
        System.out.println(name + " has been added with queue number: " + user.getQueueNumber());
        displayQueueStatus();
    }

    public synchronized void serveNextUser(int desk) {
        User nextUser = users.poll();
        if (nextUser != null) {
            System.out.println("Help Desk " + desk + " serving user: " + nextUser.getName() +
                    " (Queue number: " + nextUser.getQueueNumber() + ")");
        } else {
            System.out.println("No users in the queue.");
        }
        displayQueueStatus();
    }

    public synchronized void resetQueueNumber(int newQueueNumber) {
        System.out.println("Queue number reset to: " + newQueueNumber);
        currentQueueNumber = newQueueNumber;
        System.out.println();
    }

    private synchronized void displayQueueStatus() {
        if (users.isEmpty()) {
            System.out.println("\nQueue is empty.\n");
        } else {
            System.out.println("Next user in queue: " + users.peek().getName() +
                    " (Queue number: " + users.peek().getQueueNumber() + ")");
            System.out.println("Total users in queue: " + users.size());
            System.out.println();
        }
    }
}