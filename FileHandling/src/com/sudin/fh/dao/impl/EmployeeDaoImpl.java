/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.fh.dao.impl;

import com.sudin.fh.dao.EmployeeDAO;
import com.sudin.fh.entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joyful
 */
public class EmployeeDaoImpl implements EmployeeDAO{
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void insert(Employee e) throws Exception {
        if(check_exists(e.getEmail())){
            throw new Exception("Email address already exists.");
        }
        employeeList.add(e);
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee getByEmail(String email) {
        for(Employee e:employeeList){
            if(e.getEmail().equals(email)){
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean check_exists(String email) {
        for(Employee e:employeeList){
            if(e.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee getById(int id) {
       for(Employee e:employeeList){
           if(e.getId()==id){
               return e;
           }
       }
        return null;
    }
    
}
