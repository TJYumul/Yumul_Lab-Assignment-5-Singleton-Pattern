public class PagibigApp {
    public static void main(String[] args) {
        QueueManager queueManager = QueueManager.getInstance();

        queueManager.addUser("Bulatao");
        queueManager.addUser("TJ");
        queueManager.addUser("Saberon");

        queueManager.serveNextUser(1);
        queueManager.serveNextUser(2);
        queueManager.serveNextUser(3);

        queueManager.resetQueueNumber(1);

        queueManager.addUser("Montajes");
        queueManager.serveNextUser(1);
    }
}