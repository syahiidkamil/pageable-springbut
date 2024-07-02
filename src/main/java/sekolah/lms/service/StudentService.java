package sekolah.lms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sekolah.lms.model.Student;

import java.util.List;


public interface StudentService {
    Student create(Student request);
    Page<Student> getAll(Pageable pageable);
    Student getOne(Integer id);
    Student update(Integer id, Student request);
    void delete(Integer id);
}