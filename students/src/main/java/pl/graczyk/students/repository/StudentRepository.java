package pl.graczyk.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.graczyk.students.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
