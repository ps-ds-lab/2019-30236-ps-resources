package ro.utcluj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author bbucur
 */
@Component
public class StudentDAO {

    private final Connection connection;

    @Autowired
    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public ResultSet findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
        return statement.executeQuery();
    }

    public Integer insert(String name, String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO student (name, email) VALUES (?, ?);",
                Statement.RETURN_GENERATED_KEYS );
        statement.setString(1, name);
        statement.setString(2, email);

        statement.executeUpdate();

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating student failed, no ID obtained.");
            }
        } finally {
            statement.close();
        }
    }

    public void remove(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE id=?");
        statement.setInt(1, id);

        statement.executeUpdate();
        statement.close();
    }
}
