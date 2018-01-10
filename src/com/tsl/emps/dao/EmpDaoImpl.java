package com.tsl.emps.dao;


import com.tsl.emps.comon.jdbc.MyDbUtil;
import com.tsl.emps.comon.util.Page;
import com.tsl.emps.domain.Employee;
import com.tsl.emps.domain.Value;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpDaoImpl implements EmpDao {
    //dao  注入数据源!
    @Override
    public Employee selectEmpByName(String name) {
        Connection connection = MyDbUtil.getConnection();
        String sql = " SELECT id, empno, ename, job, mgr, hiredate, sal, comm, deptno FROM EMP where ename=? ";
        List<Employee> list = MyDbUtil.executeQuery(connection, Employee.class, sql, name);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Employee selectEmpById(Integer id) {
        Connection connection = MyDbUtil.getConnection();
        String sql = " SELECT id, empno, ename, job, mgr, hiredate, sal, comm, deptno FROM EMP where id=? ";
        List<Employee> list = MyDbUtil.executeQuery(connection, Employee.class, sql, id);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Employee> selectEmps() {
        List<Employee> list = new ArrayList<>();
        Connection connection = MyDbUtil.getConnection();
        String sql = " SELECT id, empno, ename, job, mgr, hiredate, sal, comm, deptno FROM EMP ";
        list = MyDbUtil.executeQuery(connection, Employee.class, sql);
        return list;
    }

    @Override
    public void insertEmp(Employee employee) {
        Connection conn = MyDbUtil.getConnection();
        List<Employee> list = new ArrayList<>();
        Integer empNo = employee.getEmpno();
        if (empNo == null) {
            String sqls = " SELECT id, empno, ename, job, mgr, hiredate, sal, comm, deptno FROM EMP ORDER BY empno DESC";
            list = MyDbUtil.executeQuery(conn, Employee.class, sqls);
            empNo=list.get(0).getEmpno()+1;
        }
        String sql = " insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?) ";
        MyDbUtil.executeUpdate(conn, sql, empNo, employee.getEname(), employee.getJob(), employee.getMgr(), employee.getHiredate(), employee.getSal(), employee.getComm(), employee.getDeptno());

    }

    @Override
    public void updateEmp(Employee employee) {
        Connection conn = MyDbUtil.getConnection();
        List<String> list = new ArrayList<>();
        List<Object> listvalue = new ArrayList<>();
        Integer empNo = employee.getEmpno();
        if (empNo != null) {
            list.add("empno");
            listvalue.add(empNo);
        }
        if (employee.getEname() != null) {
            list.add("ename");
            listvalue.add(employee.getEname());
        }
        if (employee.getJob() != null) {
            list.add("job");
            listvalue.add(employee.getJob());
        }
        Integer mgr = employee.getMgr();
        if (mgr != null) {
            list.add("mgr");
            listvalue.add(1);
        }
        if (employee.getHiredate() != null) {
            list.add("hiredate");
            listvalue.add(employee.getHiredate());
        }
        Double sal = employee.getSal();
        if (sal != null) {
            list.add("sal");
            listvalue.add(sal);
        }
        Double comm = employee.getSal();
        if (comm != null) {
            list.add("comm");
            listvalue.add(comm);
        }
        Integer deptno = employee.getDeptno();
        if (deptno != null) {
            list.add("deptno");
            listvalue.add(deptno);
        }
        String sql = " update emp set  ";
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if ((list.size() - 1) == i) {
                    sql = sql + s + " = ? ";
                } else {
                    sql = sql + s + " = ?, ";
                }
            }
        }
        sql = sql + " where id = ? ";
        listvalue.add(employee.getId());
        MyDbUtil.executeUpdate(conn, sql, listvalue.toArray());
    }

    @Override
    public void deleteEmpById(Integer... ids) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " delete from emp ";
        if (ids != null && ids.length > 0) {
            sql = sql + " where id in ( ";
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    sql = sql + "?";
                } else {
                    sql = sql + "?,";
                }
            }
            sql = sql + " )";
        }
        MyDbUtil.executeUpdate(conn, sql, ids);

    }

    @Override
    public int selectEmpCount() {
        Connection conn = MyDbUtil.getConnection();
        String sql = "  select  count(*) 'value' from emp ";
        List<Value> list = MyDbUtil.executeQuery(conn, Value.class, sql);
//        System.out.println(list.size());
        return (int) list.get(0).getValue();
    }

    @Override
    public Page<Employee> selectPageEmp(int id, int count) {
        List<Employee> list = new ArrayList<>();
        Connection connection = MyDbUtil.getConnection();
        String sql = " SELECT id, empno, ename, job, mgr, hiredate, sal, comm, deptno FROM EMP limit ?,? ";
        list = MyDbUtil.executeQuery(connection, Employee.class, sql, (id-1)*count, count);
        return new Page<Employee>(id,count,list,this.selectEmpCount());
    }

    public static void main(String[] args) {
        EmpDao dao = new EmpDaoImpl();
//        Employee employee = new Employee();
//        employee.setId(3);
//        employee.setEname("唐");
//
//        dao.updateEmp(employee);
//        System.out.println(listvalue.toArray()[]);
        Integer ss = 1;
        int s =ss;
        System.out.println(s);
        // dao.deleteEmpById(1,2,3);
    }
}
