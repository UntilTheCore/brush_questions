package com.utc.service.store;

import com.github.pagehelper.PageInfo;
import com.utc.domain.store.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(String id);

    void save(Company company);

    void delete(Company company);

    void update(Company company);
    PageInfo<Company> findAll(int page, int pageSize);
}
