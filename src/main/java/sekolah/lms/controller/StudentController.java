package sekolah.lms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sekolah.lms.model.Student;
import sekolah.lms.service.StudentService;
import sekolah.lms.utils.PageResponseWrapper;
import sekolah.lms.utils.Res;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student request) {
        return studentService.create(request);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size=10)Pageable pageable
            ) {
        Page<Student> res = studentService.getAll(pageable);
        PageResponseWrapper<Student> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "KETEMU",
                HttpStatus.OK
        );
    }

    //web response -> pagination
}
