package com.tsl.emps.dao;


import com.tsl.emps.comon.util.Page;
import com.tsl.emps.domain.Employee;

import java.util.List;

public interface EmpDao {
    public Employee selectEmpByName(String name);

    public Employee selectEmpById(Integer id);

    public List<Employee> selectEmps();

    public void insertEmp(Employee user);

    public void updateEmp(Employee user);

    public void deleteEmpById(Integer... ids);

    public int selectEmpCount();

    public Page<Employee> selectPageEmp(int id, int count);
}
