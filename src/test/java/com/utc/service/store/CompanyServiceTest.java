package com.utc.service.store;

import com.utc.domain.store.Company;
import com.utc.service.store.impl.CompanyServiceImpl;
import org.junit.Test;

public class CompanyServiceTest {

    @Test
    public void saveTest() {
        CompanyService companyService = new CompanyServiceImpl();

        Company company = new Company();
        company.setName("测试数据");

        companyService.save(company);
    }
}
