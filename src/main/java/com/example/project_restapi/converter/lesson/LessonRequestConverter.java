package com.example.project_restapi.converter.lesson;

import com.example.project_restapi.DTO.lesson.LessonRequest;
import com.example.project_restapi.entities.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestConverter {
    public Lesson createLesson(LessonRequest lessonRequest){
        if (lessonRequest == null){
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setLessonName(lessonRequest.getLessonName());

        return lesson;
    }


    public void updateLesson(Lesson lesson, LessonRequest lessonRequest){
        if (lessonRequest.getLessonName() != null){
            lesson.setLessonName(lessonRequest.getLessonName());
        }
    }
}
