package com.abiha.springdata.jpa1.hibernateassignment1;

import com.abiha.springdata.jpa1.hibernateassignment1.entity.Employee;
import com.abiha.springdata.jpa1.hibernateassignment1.repos.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class HibernateAssignment1ApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	//(3) Perform Create Operation on Entity using Spring Data JPA
	@Test
	public void testCreate(){

		Employee employee1 = new Employee();
		employee1.setName("Saiba");
		employee1.setAge(22);
		employee1.setLocation("Lucknow");

		repository.save(employee1);


		Employee employee2 = new Employee();
		employee2.setName("Ashtyn");
		employee2.setAge(34);
		employee2.setLocation("Austin");

		repository.save(employee2);

	}

	//(5) Perform Read Operation on Entity using Spring Data JPA
	@Test
	public void testRead(){
		Employee employee = repository.findById(1).get();
		Assertions.assertNotNull(employee);
		Assertions.assertEquals("Abiha", employee.getName());
	}

	//(4) Perform Update Operation on Entity using Spring Data JPA
	@Test
	public void testUpdate(){
		Employee employee = repository.findById(1).get();

		employee.setLocation("Delhi");
		repository.save(employee);
	}

	//(5) Perform Delete Operation on Entity using Spring Data JPA
	@Test
	public void testDelete(){
		if(repository.existsById(1))
			repository.deleteById(1);
	}

	//(6) Get the total count of the number of Employees
	@Test
	public void testCount(){
		System.out.println("Total records ===============>>>>>>>>>>" +repository.count());
	}

	//(7) Implement Pagination and Sorting on the bases of Employee Age
	@Test
	public void testPagingAndSortingOnAge(){
		Pageable pageable = PageRequest.of(0,2, Sort.Direction.ASC, "age");
		repository.findAll(pageable).forEach(e -> System.out.println(e.getName()));
	}

	//(8) Create and use finder to find Employee by Name
	@Test
	public void testFindByName(){
		List<Employee> employees = repository.findByName("Abiha");
		employees.forEach(e-> System.out.println(e.getAge()));
	}

	//(9) Create and use finder to find Employees starting with A character
	@Test
	public void testFindByNameLike(){
		List<Employee> employees = repository.findByNameLike("A%");
		employees.forEach(e-> System.out.println(e.getName()));
	}

	//(10) Create and use finder to find Employees Between the age of 28 to 32
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employees = repository.findByAgeBetween(28,32);
		employees.forEach(e-> System.out.println(e.getName()));
	}



}
