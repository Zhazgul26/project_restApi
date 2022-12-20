package com.example.project_restapi.service.impl;

import com.example.project_restapi.DTO.company.CompanyRequest;
import com.example.project_restapi.DTO.company.CompanyResponse;
import com.example.project_restapi.converter.company.CompanyRequestConverter;
import com.example.project_restapi.converter.company.CompanyResponseConverter;
import com.example.project_restapi.entities.Company;
import com.example.project_restapi.repository.CompanyRepository;
import com.example.project_restapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    private final CompanyRequestConverter companyRequestConverter;

    private final CompanyResponseConverter companyResponseConverter;


    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyResponseConverter.view(repository.findAll());
    }

    @Override
    public CompanyResponse addCompany(CompanyRequest companyRequest) throws IOException {
//        validator(companyRequest.getCompanyName(), companyRequest.getLocatedCountry());

        Company company = companyRequestConverter.createCompany(companyRequest);
        repository.save(company);

        return companyResponseConverter.viewCompany(company);
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = repository.findById(id).get();
        return companyResponseConverter.viewCompany(company);
    }

    @Override
    public CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) throws IOException {


        Company company1 = repository.findById(companyId).get();
        companyRequestConverter.updateCompany(company1, companyRequest);
        repository.save(company1);
        return companyResponseConverter.viewCompany(company1);

    }

    @Override
    public CompanyResponse deleteCompany(Long companyId ) {

        Company company = repository.findById(companyId).get();
        repository.delete(company);
        return companyResponseConverter.viewCompany(company);
    }

//    private void validator(String companyName, String locatedCountry) throws IOException {
//        if (companyName.length()>2 && locatedCountry.length()>2) {
//            for (Character i : companyName.toCharArray()) {
//                if (!Character.isAlphabetic(i)) {
//                    throw new IOException("В названи компании нельзя вставлять цифры");
//                }
//            }
//            for (Character i : locatedCountry.toCharArray()) {
//                if (!Character.isAlphabetic(i)) {
//                    throw new IOException("В названии страны нельзя вставлять цифры");
//                }
//            }
//        }else {
//            throw new IOException("В название компании или страны должно быть как минимум 3 буквы");
//        }
//    }


}
