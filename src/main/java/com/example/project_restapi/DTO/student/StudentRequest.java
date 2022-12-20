package com.example.project_restapi.DTO.student;

import com.example.project_restapi.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private StudyFormat studyFormat;
}
