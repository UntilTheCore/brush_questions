package com.utc.service.store;

import com.utc.domain.store.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById();

    void save(Company company);

    int delete(String id);

    int update(Company company);
}
