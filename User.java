public class User {
    private final String name;
    private final int queueNumber;

    public User(String name, int queueNumber) {
        this.name = name;
        this.queueNumber = queueNumber;
    }

    public String getName() {
        return name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }
}

