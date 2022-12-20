package com.example.project_restapi.service;


import com.example.project_restapi.DTO.course.CourseRequest;
import com.example.project_restapi.DTO.course.CourseResponse;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses(Long id);

    CourseResponse addCourse(Long id, CourseRequest courseRequest) throws IOException;

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest) throws IOException;

    CourseResponse deleteCourse(Long id);
}
