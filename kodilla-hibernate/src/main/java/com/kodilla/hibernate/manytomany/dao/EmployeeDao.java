package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> findByFirstName(@Param("NAME") String name);

    @Query
    List<Employee> findEmployeeFirstnameContaining(@Param("ARG") String arg);

    @Query
    List<Employee> findEmployeeLastnameContaining(@Param("ARG") String arg);

}