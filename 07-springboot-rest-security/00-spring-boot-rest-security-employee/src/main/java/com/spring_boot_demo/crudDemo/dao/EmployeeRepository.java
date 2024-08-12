package com.spring_boot_demo.crudDemo.dao;

import com.spring_boot_demo.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// JPA repository handles the in-build CRUD operations for multiple entities
// JPARepository<Entity, Primary Key> = JPARepository<Employee, Integer>
// RepositoryRestResource is used to costumize the RESTful endpoints.
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // we don't need to implement the code as all CRUD functions will be provided by JpaRepository
}

