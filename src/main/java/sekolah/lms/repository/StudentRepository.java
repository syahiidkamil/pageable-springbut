package sekolah.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sekolah.lms.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
