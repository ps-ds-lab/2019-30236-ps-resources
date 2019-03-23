package ro.utcluj;


import ro.utcluj.dao.StudentDAO;
import ro.utcluj.mapper.StudentMapper;
import ro.utcluj.enitity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "root", "root");
        StudentDAO studentDAO = new StudentDAO(connection);
        StudentMapper mapper = new StudentMapper(studentDAO);

        studentDemo(mapper);
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

}
