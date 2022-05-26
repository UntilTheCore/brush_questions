package com.utc.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utc.dao.store.CompanyDao;
import com.utc.domain.store.Company;
import com.utc.factory.MapperFactory;
import com.utc.service.store.CompanyService;
import com.utc.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<Company> findAll() {
        SqlSession session = null;
        List<Company> companyList;

        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);

            companyList = mapper.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
        return companyList;
    }

    @Override
    public Company findById(String id) {
        SqlSession session = null;
        Company company;

        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);

            company = mapper.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
        return company;
    }

    @Override
    public void save(Company company) {
        SqlSession session = null;

        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);
            String uuid = UUID.randomUUID().toString();
            company.setId(uuid);

            int i = mapper.save(company);
            TransactionUtil.commit(session);
        } catch (Exception e) {
            TransactionUtil.rollback(session);
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
    }

    @Override
    public void delete(Company company) {
        SqlSession session = null;

        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);

            int i = mapper.delete(company);
            TransactionUtil.commit(session);
        } catch (Exception e) {
            TransactionUtil.rollback(session);
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
    }

    @Override
    public PageInfo<Company> findAll(int page, int pageSize) {
        SqlSession session = null;
        PageInfo<Company> pageInfo;
        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);
            PageHelper.startPage(page, pageSize);
            List<Company> companyList = mapper.findAll();
            pageInfo = new PageInfo<>(companyList);
        } catch (Exception e) {
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
        return pageInfo;
    }

    @Override
    public void update(Company company) {
        SqlSession session = null;

        try {
            session = MapperFactory.getSession();
            CompanyDao mapper = MapperFactory.getMapper(session, CompanyDao.class);

            int i = mapper.update(company);
            TransactionUtil.commit(session);
        } catch (Exception e) {
            TransactionUtil.rollback(session);
            throw new RuntimeException(e);
            // 保留日志
        } finally {
            TransactionUtil.close(session);
        }
    }
}
