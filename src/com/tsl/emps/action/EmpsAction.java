package com.tsl.emps.action;


import com.tsl.emps.comon.util.Page;
import com.tsl.emps.domain.Employee;
import com.tsl.emps.serviece.EmpService;
import com.tsl.emps.serviece.EmpServiceImpl;
import com.tsl.framework.mvc.annotation.RequestPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestPath("/emp")
public class EmpsAction {
    private EmpService empService;

    public EmpsAction() {
        this.empService = new EmpServiceImpl();
    }

    @RequestPath("/list")
    public String list(HttpServletRequest res, HttpServletResponse resp) {
        String pageCurrent = res.getParameter("pageCurrent");
        String pageSize = res.getParameter("pageSize");
        Page<Employee> allEmp = empService.findPageEmp(Integer.parseInt(pageCurrent), Integer.parseInt(pageSize));
        res.setAttribute("allEmp", allEmp);
        return "WEB-INF/emp/emp_list.jsp";
    }

    @RequestPath("/del")
    public String del(HttpServletRequest res, HttpServletResponse resp) {
        String id = res.getParameter("id");
        empService.removeEmpById(Integer.parseInt(id));
        return "WEB-INF/emp/emp_del_success.jsp";

    }
    @RequestPath("/delchecked")
    public String delchecked(HttpServletRequest res, HttpServletResponse resp) {
        String ids = res.getParameter("ids");
        String[] split = ids.split(",");
        for (String s:split) {
            int id = Integer.parseInt(s);
            empService.removeEmpById(id);
        }
        return "WEB-INF/emp/emp_del_success.jsp";
    }

    @RequestPath("/add")
    public String add(HttpServletRequest res, HttpServletResponse resp) {
        Employee employee = new Employee();
        employee.setEname(res.getParameter("name"));
        Date date = null;
        try {
             date = new SimpleDateFormat("yyyy-MM-dd").parse(res.getParameter("hireDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setSal(Double.valueOf(res.getParameter("sal")));
        employee.setHiredate(date);
        empService.addEmp(employee);
        res.setAttribute("fixEmp",employee);

        return "WEB-INF/emp/emp_add_success.jsp";
    }
    @RequestPath("/toadd")
    public String toadd(HttpServletRequest res, HttpServletResponse resp) {
        return "WEB-INF/emp/emp_add.jsp";
    }

    @RequestPath("/toedit")
    public String toedit(HttpServletRequest res, HttpServletResponse resp) {
        String id = res.getParameter("id");
        res.setAttribute("employee", empService.findEmpById(Integer.parseInt(id)));
        return "WEB-INF/emp/emp_edit.jsp";

    }

    @RequestPath("/edit")
    public String edit(HttpServletRequest res, HttpServletResponse resp) {
        Employee emp = new Employee();
        emp.setId(Integer.valueOf(res.getParameter("id")));
        int empno = Integer.parseInt(res.getParameter("empno"));
        emp.setEmpno(empno);
        String ename = res.getParameter("ename");
        emp.setEname(ename);
        String job = res.getParameter("job");
        emp.setJob(job);
        Integer mgr = Integer.parseInt(res.getParameter("mgr"));
        emp.setMgr(mgr);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(res.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emp.setHiredate(date);
        double sal = Double.parseDouble(res.getParameter("sal"));
        emp.setSal(sal);
        empService.editEmp(emp);
        res.setAttribute("fixEmp",emp);
        return "WEB-INF/emp/emp_edit_success.jsp";
    }
    @RequestPath("/show")
    public String show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        Employee employee = empService.findEmpById(Integer.parseInt(id));
        request.setAttribute("employee",employee);
        return "/WEB-INF/emp/emp_show.jsp";
    }
}
