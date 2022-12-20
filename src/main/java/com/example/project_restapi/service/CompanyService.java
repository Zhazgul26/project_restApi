package com.example.project_restapi.service;



import com.example.project_restapi.DTO.company.CompanyRequest;
import com.example.project_restapi.DTO.company.CompanyResponse;

import java.io.IOException;
import java.util.List;


public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest companyRequest) throws IOException;

    CompanyResponse getCompanyById(Long id);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) throws IOException;

    CompanyResponse deleteCompany(Long companyId);
}
