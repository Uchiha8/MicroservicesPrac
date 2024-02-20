package com.alibou.school.constructor;

import com.alibou.school.domain.School;
import com.alibou.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolConstructor {


    private final SchoolService schoolService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
        return ResponseEntity.ok("School saved successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }
}
