import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueManager {
    private static QueueManager instance;
    private final AtomicInteger currentQueueNumber = new AtomicInteger(100); // Starts at 100
    private final List<User> users = new ArrayList<>();

    private QueueManager() {}

    public static synchronized QueueManager getInstance() {
        if (instance == null) {
            instance = new QueueManager();
        }
        return instance;
    }

    public User createUser(String name) {
        int userQueueNumber = currentQueueNumber.get(); // Use current queue number for the user
        User user = new User(name, userQueueNumber);
        users.add(user);
        System.out.println(name + " has been added with queue number: " + userQueueNumber);
        currentQueueNumber.incrementAndGet(); // Increment for the next user
        return user;
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber.get();
    }

    public List<User> getUsers() {
        return users;
    }

    public void serveNextUser() {
        if (!users.isEmpty()) {
            User nextUser = users.remove(0);
            System.out.println("Serving user: " + nextUser.getName() + " (Your queue number: " + nextUser.getQueueNumber() + ")");
            System.out.println("Current queue in Pag-ibig: " + (nextUser.getQueueNumber() + 1));
        } else {
            System.out.println("No users in the queue.");
        }
    }

}