package com.example.project_restapi.DTO.instructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorRequest {
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String specialization;
}
