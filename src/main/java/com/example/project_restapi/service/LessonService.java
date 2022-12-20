package com.example.project_restapi.service;


import com.example.project_restapi.DTO.lesson.LessonRequest;
import com.example.project_restapi.DTO.lesson.LessonResponse;

import java.util.List;

public interface LessonService {
    List<LessonResponse> getAllLessons(Long id);

    LessonResponse addLesson(Long id, LessonRequest lessonRequest);

    LessonResponse getLessonById(Long id);

    LessonResponse updateLesson(LessonRequest lessonRequest, Long id);

    LessonResponse deleteLesson(Long id);
}
