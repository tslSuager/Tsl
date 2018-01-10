package com.tsl.emps.serviece;


import com.tsl.emps.comon.util.Page;
import com.tsl.emps.domain.Employee;

public interface EmpService {

    Page<Employee> findPageEmp(int pageCurrent, int pageSize);

    void removeEmpById(int id);

    Employee findEmpById(int i);

    void editEmp(Employee emp);

    void addEmp(Employee employee);
}
