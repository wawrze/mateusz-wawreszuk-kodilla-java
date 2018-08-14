package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class Facade {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> findEmployee(String nameFragment) {
        List<Employee> resultList = new ArrayList<>();
        resultList.addAll(employeeDao.findEmployeeFirstnameContaining("%" + nameFragment + "%"));
        resultList.addAll(employeeDao.findEmployeeLastnameContaining("%" + nameFragment + "%"));
        return resultList;
    }

    public List<Company> findCompany(String nameFragment) {
        return companyDao.findCompanyNameContaining("%" + nameFragment + "%");
    }

}