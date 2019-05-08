package ro.utcluj.mapper;

import org.springframework.stereotype.Component;
import ro.utcluj.dto.StudentInfoDTO;
import ro.utcluj.enitity.Student;

@Component
public class StudentInfoMapper {

    public StudentInfoDTO map(Student student) {
        StudentInfoDTO dto = new StudentInfoDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        return dto;
    }
}
