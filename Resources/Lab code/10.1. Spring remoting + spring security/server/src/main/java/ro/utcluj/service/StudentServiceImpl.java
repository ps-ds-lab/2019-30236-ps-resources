package ro.utcluj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcluj.api.StudentService;
import ro.utcluj.dto.StudentInfoDTO;
import ro.utcluj.enitity.Student;
import ro.utcluj.mapper.StudentInfoMapper;
import ro.utcluj.repository.StudentRepository;

@Component
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentInfoMapper mapper;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, StudentInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void updateStudentEmail(Integer studentId, String email){
        Student student = repository.getOne(studentId);
        student.setEmail(email);
    }

    public StudentInfoDTO getStudent(Integer id) {
        Student student = repository.getOne(id);
        return mapper.map(student);
    }
}
