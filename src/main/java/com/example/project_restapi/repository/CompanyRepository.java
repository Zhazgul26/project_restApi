package com.example.project_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project_restapi.entities.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
