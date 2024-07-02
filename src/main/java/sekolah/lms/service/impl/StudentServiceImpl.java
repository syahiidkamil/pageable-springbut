package sekolah.lms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sekolah.lms.model.Student;
import sekolah.lms.repository.StudentRepository;
import sekolah.lms.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student create(Student request) {
        String prefixNim = request.getName() + request.getBirthDate();
        request.setNim(prefixNim);
        return studentRepository.save(request);
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getOne(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(Integer id, Student request) {
        Student student = this.getOne(id);
        student.setName(request.getName());
        student.setNim(request.getNim());
        student.setBirthDate(request.getBirthDate());
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
