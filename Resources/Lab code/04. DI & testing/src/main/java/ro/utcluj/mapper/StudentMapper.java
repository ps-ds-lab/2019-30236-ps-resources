package ro.utcluj.mapper;

import ro.utcluj.dao.StudentDAO;
import ro.utcluj.enitity.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bbucur
 */
public class StudentMapper {

    private final StudentDAO studentDAO;

    public StudentMapper(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> findAll() throws SQLException {
        List<Student> students = new LinkedList<>();
        ResultSet resultSet = studentDAO.findAll();

        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));

            students.add(student);
        }

        resultSet.close();

        return students;
    }

    public Student insert(Student student) throws SQLException {
        Integer studentId = studentDAO.insert(student.getName(), student.getEmail());

        student.setId(studentId);

        return student;
    }

    public void remove(Student student) throws SQLException {
        studentDAO.remove(student.getId());
    }
}
