/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.repository;
import com.webs.mumscrum.domain.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 984627
 */
@Repository
public interface EmployeeRepository  extends CrudRepository<Employee,Long>{

	@Query("select e from Employee e left join e.roles er where er.id = ?1")
	List<Employee> findEmployeesByRole(Long role);

	@Query("select e from Employee e where e.username = ?1")
	Employee getEmployeeByUsername(String username);
}
