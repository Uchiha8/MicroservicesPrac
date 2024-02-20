package com.alibou.student.constructor;

import com.alibou.student.domain.Student;
import com.alibou.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentConstructor {

    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student saved successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
