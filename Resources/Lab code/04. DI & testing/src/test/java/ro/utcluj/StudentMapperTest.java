package ro.utcluj;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import ro.utcluj.dao.StudentDAO;
import ro.utcluj.enitity.Student;
import ro.utcluj.mapper.StudentMapper;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author bbucur
 */
public class StudentMapperTest {

    private StudentMapper target;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private StudentDAO studentDAO;

    @Before
    public void setup(){
        target = new StudentMapper(studentDAO);
    }

    @Test
    public void testInsert() throws SQLException {
        // given
        String name = "student1";
        String email = "student1@utcluj.ro";
        Student student = new Student(null, name, email);
        when(studentDAO.insert(anyString(), anyString())).thenReturn(42);

        // when
        Student returnedStudent = target.insert(student);

        // then
        verify(studentDAO, Mockito.times(1)).insert(name, email);
        assertEquals(42, returnedStudent.getId().intValue());
    }
}
