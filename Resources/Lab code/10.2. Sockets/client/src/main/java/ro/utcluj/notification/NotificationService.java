package ro.utcluj.notification;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@Component
public class NotificationService {

    @PostConstruct
    public void connectToNotificationServer() throws IOException {
        Socket socket = new Socket("localhost", 8081);

        Thread listenerThread = new Thread(new ServerSocketListener(socket));
        listenerThread.start();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("first message");
        out.println("second message");
    }

}
