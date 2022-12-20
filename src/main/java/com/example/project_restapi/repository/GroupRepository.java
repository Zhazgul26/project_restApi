package com.example.project_restapi.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_restapi.entities.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(value = "select c from Group c where c.company.id = :companyId")
    List<Group> getAllGroup(Long companyId);
}
