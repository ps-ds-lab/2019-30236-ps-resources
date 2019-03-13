package ro.utcluj.mapper;

import ro.utcluj.enitity.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bbucur
 */
public class StudentMapper {

    private final Connection connection;

    public StudentMapper() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "limited_access_user", "strong_password"); 
    }

    public List<Student> findAll() throws SQLException {
        List<Student> students = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));

            students.add(student);
        }

        resultSet.close();
        statement.close();

        return students;
    }

    public void insert(Student student) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO student (name, email) VALUES (?, ?);");
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());

        statement.executeUpdate();
        statement.close();
    }

    public void remove(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE id=?");
        statement.setInt(1, id);

        statement.executeUpdate();
        statement.close();
    }
}
