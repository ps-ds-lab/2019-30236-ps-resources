package ro.utcluj;


import ro.utcluj.mapper.StudentMapper;
import ro.utcluj.enitity.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException {
        StudentMapper mapper = new StudentMapper();

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
