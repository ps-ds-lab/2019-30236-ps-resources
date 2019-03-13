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

        mapper.insert(new Student(null, "Sergiu", "sergiu@sergiu.com"));
        List<Student> studentList = mapper.findAll();

        for (Student student: studentList){
            System.out.println(String.format("Student %s has email %s", student.getName(), student.getEmail()));
        }
    }

}
