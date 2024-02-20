package com.alibou.school.service;

import com.alibou.school.client.StudentClient;
import com.alibou.school.domain.FullSchoolResponse;
import com.alibou.school.domain.School;
import com.alibou.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(null);
        // implement the logic to find students by school id
        var student = client.findAllStudentsBySchoolId(schoolId);
        assert school != null;
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(student)
                .build();
    }
}
