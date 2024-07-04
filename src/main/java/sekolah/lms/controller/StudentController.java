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
            @PageableDefault(size=10)Pageable pageable,
            @RequestParam(required = false) String name
            ) {
        return Res.renderJson(
                new PageResponseWrapper<>(studentService.getAll(pageable, name)),
                "KETEMU",
                HttpStatus.OK
        );
    }

    // car rent,
    // car, brand, users -> specfication, by name
    // car -> by name + by available

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Res.renderJson(
                studentService.getOne(id),
                "found",
                HttpStatus.OK
        );
    }

    // Validation
    // Specification -> getByName
    // JWT security
    // REST TEMPLATE -> backend konsumsi API dari luar
    // Docker ->

    //web response -> pagination
}
