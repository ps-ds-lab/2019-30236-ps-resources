package ro.utcluj.api;

import ro.utcluj.dto.StudentInfoDTO;

public interface StudentService {

    void updateStudentEmail(Integer studentId, String email);

    StudentInfoDTO getStudent(Integer id);
}
