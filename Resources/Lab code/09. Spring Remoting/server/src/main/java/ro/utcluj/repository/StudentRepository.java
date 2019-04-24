package ro.utcluj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.utcluj.enitity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
