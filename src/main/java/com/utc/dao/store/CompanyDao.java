package com.utc.dao.store;

import com.utc.domain.store.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> findAll();

    Company findById();

    int save(Company company);

    int delete(String id);

    int update(Company company);
}
