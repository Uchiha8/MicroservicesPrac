package com.alibou.school.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullSchoolResponse {
    private String name;
    private String email;
    List<Student> students;
}
