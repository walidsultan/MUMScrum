/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.service;

import com.webs.mumscrum.domain.Employee;
import com.webs.mumscrum.domain.EmployeeRole;
import java.util.List;

/**
 *
 * @author 984627
 */
public interface HRSubsystemService {
    public Employee getEmployeeById(Long id);
    public void saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByRole(Long role);
    public boolean isCorrectUsernameAndPassword(String username, String password);
}
