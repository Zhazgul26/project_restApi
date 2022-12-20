package com.example.project_restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_restapi.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select c from Task c where c.lesson.id = :lessonId")
    List<Task> getAllTasks(Long lessonId);
}
