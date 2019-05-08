package ro.utcluj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * Hello world!
 */
@SpringBootApplication
public class Server {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Server.class, args);
    }

}
