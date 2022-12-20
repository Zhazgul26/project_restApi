package com.example.project_restapi.DTO.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    private String companyName;

    private String locatedCountry;

//    private List<Course> courses;
//
//    private List<Group> groups;
}
