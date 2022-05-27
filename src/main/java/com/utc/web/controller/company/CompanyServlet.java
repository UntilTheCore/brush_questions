package com.utc.web.controller.company;

import com.github.pagehelper.PageInfo;
import com.utc.domain.store.Company;
import com.utc.service.store.impl.CompanyServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store/company")
public class CompanyServlet extends HttpServlet {

    protected void getCompanyPagingList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int size = 5;
        if(StringUtils.isNotBlank(req.getParameter("page"))) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if(StringUtils.isNotBlank(req.getParameter("size"))) {
            size = Integer.parseInt(req.getParameter("size"));
        }

        PageInfo<Company> all = new CompanyServiceImpl().findAll(page, size);
        req.setAttribute("page", all);
        req.getRequestDispatcher("/WEB-INF/pages/store/company/list.jsp").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        switch (operation) {
            case "list":
                getCompanyPagingList(req, resp);
                break;
            case "add":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
