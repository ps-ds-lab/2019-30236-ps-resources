package ro.utcluj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcluj.enitity.Address;
import ro.utcluj.enitity.Student;
import ro.utcluj.repository.StudentRepository;

import java.util.List;

@Component
@Transactional
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void updateStudentEmail(Integer studentId, String email){
        Student student = repository.getOne(studentId);
        student.setEmail(email);
    }

    public void printStudents(){
        List<Student> students = repository.findAll();

        for (Student student: students){
            System.out.println(student.getName());
            System.out.println(student.getEmail());

            if (student.getAddressSet() != null && !student.getAddressSet().isEmpty()){
                for(Address address: student.getAddressSet()){
                    System.out.println(address.getId());
                    System.out.println(address.getCity());
                    System.out.println(address.getStreet());
                }


            }
        }

    }

}
