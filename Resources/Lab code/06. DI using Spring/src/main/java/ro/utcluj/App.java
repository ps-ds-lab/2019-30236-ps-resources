package ro.utcluj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ro.utcluj.enitity.Student;
import ro.utcluj.mapper.StudentMapper;

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
        studentDemo(context.getBean(StudentMapper.class));
    }

    private static void studentDemo(StudentMapper mapper) throws SQLException {
        System.out.println("--- Initial findAll ---");

        for (Student student: mapper.findAll()){
            System.out.println(String.format("Student %s has email %s", student.getName(), student.getEmail()));
        }

        System.out.println("--- After insert ---");

        Student insertedStudent = mapper.insert(new Student(null, "Sergiu", "sergiu@sergiu.com"));
        for (Student student: mapper.findAll()){
            System.out.println(String.format("Student %s has email %s", student.getName(), student.getEmail()));
        }

        System.out.println("--- After remove ---");

        mapper.remove(insertedStudent);
        for (Student student: mapper.findAll()){
            System.out.println(String.format("Student %s has email %s", student.getName(), student.getEmail()));
        }
    }

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "root", "root");
    }
}
