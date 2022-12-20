package com.example.project_restapi.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_restapi.entities.Instructor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query(value = "select c from Instructor c where c.course.id = :courseId")
    List<Instructor> getAllInstructor(Long courseId);
}
