package com.tsl.emps.serviece;

import com.tsl.emps.comon.util.Page;
import com.tsl.emps.dao.EmpDao;
import com.tsl.emps.dao.EmpDaoImpl;
import com.tsl.emps.domain.Employee;
import com.tsl.emps.domain.User;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao;

    public EmpServiceImpl() {
        this.empDao = new EmpDaoImpl();
    }


    @Override
    public Page<Employee> findPageEmp(int pageCurrent, int pageSize) {
        return empDao.selectPageEmp(pageCurrent, pageSize);
    }

    @Override
    public void removeEmpById(int id) {
        empDao.deleteEmpById(id);
    }

    @Override
    public Employee findEmpById(int id) {
        return empDao.selectEmpById(id);
    }

    @Override
    public void editEmp(Employee emp) {
        empDao.updateEmp(emp);
    }

    @Override
    public void addEmp(Employee employee) {
        empDao.insertEmp(employee);

    }
}
