package ro.utcluj.notification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Runnable listening for incoming messages from the server
 */
public class ServerSocketListener implements Runnable {

    private final Socket serverSocket;

    public ServerSocketListener(Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            while (true) {
                System.out.println(in.readLine());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("The server is no longer available");
        }
    }
}
