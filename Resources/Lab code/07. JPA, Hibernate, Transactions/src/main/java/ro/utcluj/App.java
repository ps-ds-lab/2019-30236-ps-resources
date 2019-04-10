package ro.utcluj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ro.utcluj.enitity.Student;
import ro.utcluj.repository.StudentRepository;
import ro.utcluj.service.StudentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(App.class, args);
        StudentService service = context.getBean(StudentService.class);
        service.printStudents();
        service.updateStudentEmail(8, "beniaminbucur@gmail.com");
        service.printStudents();
    }
}
