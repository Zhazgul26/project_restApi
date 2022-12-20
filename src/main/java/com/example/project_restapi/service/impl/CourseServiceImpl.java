package com.example.project_restapi.service.impl;


import com.example.project_restapi.DTO.course.CourseRequest;
import com.example.project_restapi.DTO.course.CourseResponse;
import com.example.project_restapi.converter.course.CourseRequestConverter;
import com.example.project_restapi.converter.course.CourseResponseConverter;
import com.example.project_restapi.entities.Company;
import com.example.project_restapi.entities.Course;
import com.example.project_restapi.repository.CompanyRepository;
import com.example.project_restapi.repository.CourseRepository;
import com.example.project_restapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseResponseConverter courseResponseConverter;
    private final CourseRequestConverter courseRequestConverter;

//    @Override
//    public List<Course> getAllCourses(Long id) {
//        return  courseRepository.getAllCourses(id);
//    }
//
//    @Override
//    public void addCourse(Long id, Course course) throws IOException {
//        validator(course.getCourseName().replace(" ", ""), course.getDescription().replace(" ", ""), course.getDuration());
//        Company company = companyRepository.getById(id);
//        company.addCourse(course);
//        course.setCompany(company);
//        courseRepository.save(course);
//    }
//
//    @Override
//    public Course getCourseById(Long id) {
//        return courseRepository.getById(id);
//    }
//
//    @Override
//    public void updateCourse(Course course, Long id) throws IOException {
//        validator(course.getCourseName(), course.getDescription(), course.getDuration());
//        Course course1 = courseRepository.getById(id);
//        course1.setCourseName(course.getCourseName());
//        course1.setDuration(course.getDuration());
//        course1.setDescription(course.getDescription());
//        courseRepository.save(course1);
//    }
//
//    @Override
//    public void deleteCourse(Long id) {
//        Course course = courseRepository.getById(id);
//        courseRepository.delete(course);
//    }

    @Override
    public List<CourseResponse> getAllCourses(Long id) {
        return courseResponseConverter.view(courseRepository.getAllCourses(id));
    }

    @Override
    public CourseResponse addCourse(Long id, CourseRequest courseRequest) throws IOException {
        Course course = courseRequestConverter.createCourse(courseRequest);
        Company company = companyRepository.getById(id);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) throws IOException {
        Course course = courseRepository.findById(id).get();
        courseRequestConverter.updateCourse(course, courseRequest);
        courseRepository.save(course);

        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseResponseConverter.viewCourse(course);
    }


}