package com.utc.service.store;

import com.github.pagehelper.PageInfo;
import com.utc.domain.store.Company;
import com.utc.service.store.impl.CompanyServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class CompanyServiceTest {
    private static CompanyService companyService = null;

    @BeforeClass
    public static void init() {
        companyService = new CompanyServiceImpl();
    }

    @Test
    public void saveTest() {
        Company company = new Company();
        company.setName("测试数据2");
        companyService.save(company);
    }

    @Test
    public void findAllTest() {
        List<Company> list = companyService.findAll();
        for (Company company : list) {
            System.out.println(company);
        }
    }

    @Test
    public void findAllAndPagingTest() {
        PageInfo<Company> pageInfo = companyService.findAll(1, 100);
        System.out.println(pageInfo);
    }

    @Test
    public void findByIdTest() {
        Company company = companyService.findById("3");
        System.out.println(company);
    }

    @Test
    public void delete() {
        Company company = companyService.findById("2d8b43ae-9a38-497c-a01b-131c214c1f1a");
        companyService.delete(company);
    }

    @Test
    public void update() {
        Company company = companyService.findById("0fb82c77-c4f0-405d-9938-18d63687b645");
        company.setName("我是谁");
        companyService.update(company);
    }

    @AfterClass
    public static void destory() {
        companyService = null;
    }
}
