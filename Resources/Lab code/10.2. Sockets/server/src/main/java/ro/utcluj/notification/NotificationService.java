package ro.utcluj.notification;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@EnableScheduling
public class NotificationService {
    private static final int PORT_NUMBER = 8081;

    private final List<ClientSocketConnection> connectedClients = new CopyOnWriteArrayList<>();

    public NotificationService() {
        System.out.println();
    }

    @PostConstruct
    public void startServer() {
        Thread thread = new Thread(this::startNotificationServer); // starts a thread which runs the startNotificationServer method
        thread.start();
    }

    private void startNotificationServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientSocketConnection clientConnection = new ClientSocketConnection(clientSocket, this);
                connectedClients.add(clientConnection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAllClients(String message) {
        for (ClientSocketConnection connection : connectedClients) {
            connection.sendMessage(message);
        }
    }

    void removeClient(ClientSocketConnection clientConnection) {
        connectedClients.remove(clientConnection);
    }

}
