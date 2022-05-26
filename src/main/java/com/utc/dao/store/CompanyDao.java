package com.utc.dao.store;

import com.github.pagehelper.PageInfo;
import com.utc.domain.store.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> findAll();

    Company findById(String id);

    int save(Company company);

    int delete(Company company);

    int update(Company company);

}
