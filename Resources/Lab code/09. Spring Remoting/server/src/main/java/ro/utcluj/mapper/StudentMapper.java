package ro.utcluj.mapper;

import org.springframework.stereotype.Component;
import ro.utcluj.api.StudentBaseDTO;
import ro.utcluj.enitity.Student;

@Component
public class StudentMapper {

    public StudentBaseDTO map(Student student){
        StudentBaseDTO dto = new StudentBaseDTO();
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}
