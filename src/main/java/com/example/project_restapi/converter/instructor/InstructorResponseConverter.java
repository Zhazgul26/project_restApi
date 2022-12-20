package com.example.project_restapi.converter.instructor;

import com.example.project_restapi.DTO.instructor.InstructorResponse;
import com.example.project_restapi.entities.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorResponseConverter {
    public InstructorResponse viewInstructor(Instructor instructor){
        if (instructor==null){
            return null;
        }

        InstructorResponse instructorResponse = new InstructorResponse();

        instructorResponse.setId(instructor.getId());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setLastName(instructor.getLastName());
        instructorResponse.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponse.setFirstName(instructor.getFirstName());
        instructorResponse.setSpecialization(instructor.getSpecialization());

        return instructorResponse;
    }

    public List<InstructorResponse> view(List<Instructor> instructors){
        List<InstructorResponse> instructorResponses = new ArrayList<>();

        for (Instructor instructor: instructors) {
            instructorResponses.add(viewInstructor(instructor));
        }

        return  instructorResponses;
    }
}
