package ro.utcluj.api;

public interface StudentService {

    void updateStudentEmail(Integer studentId, String email);

    StudentBaseDTO getStudent(Integer id);
}
