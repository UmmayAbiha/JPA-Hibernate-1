package com.abiha.springdata.jpa1.hibernateassignment1.repos;

import com.abiha.springdata.jpa1.hibernateassignment1.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

// Q2 Set up EmployeeRepository with Spring Data JPA

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByNameLike(String s);

    List<Employee> findByAgeBetween(int a1,int a2);

}

