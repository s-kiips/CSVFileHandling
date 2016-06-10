/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.fh.dao;

import com.sudin.fh.entity.Employee;
import java.util.List;

/**
 *
 * @author ranji
 */
public interface EmployeeDAO {
    void insert(Employee e)throws Exception;
    Employee getById(int id);
    Employee getByEmail(String email);
    List<Employee> getAll();
    boolean check_exists(String email);
}
