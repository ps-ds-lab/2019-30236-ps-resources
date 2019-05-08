package ro.utcluj.notification;

import java.io.*;
import java.net.Socket;

/**
 * Runnable listening for incoming messages from the client
 */
class ClientSocketConnection {

    private final NotificationService notificationService;
    private BufferedReader in;
    private PrintWriter out;

    ClientSocketConnection(Socket clientSocket, NotificationService notificationService) {
        this.notificationService = notificationService;
        createReaderAndWriter(clientSocket);
        new Thread(this::listenAndRespond).start(); // starting a new thread which listens to client messages
    }

    private void createReaderAndWriter(Socket clientSocket) {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (Exception exception) {
            System.out.println("Client disconnected");
        }
    }

    /**
     * Listening for messages from the client, printing them to the console and responding to them
     */
    private void listenAndRespond() {
        try {
            while (true) {
                String received = in.readLine();
                System.out.println("Received: " + received);
                out.println("I received the object");
            }
        } catch (Exception exception) {
            System.out.println("Client disconnected");
            notificationService.removeClient(this);
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
}
