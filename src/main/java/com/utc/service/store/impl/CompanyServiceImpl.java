package com.utc.service.store.impl;

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
        return null;
    }

    @Override
    public Company findById() {
        return null;
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
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(Company company) {
        return 0;
    }
}
