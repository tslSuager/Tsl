package com.tsl.emps.action;

import com.tsl.emps.comon.util.JsonUtil;
import com.tsl.emps.comon.util.Page;
import com.tsl.emps.domain.Employee;
import com.tsl.emps.serviece.EmpService;
import com.tsl.emps.serviece.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listemp")
public class ListEMpServlet extends HttpServlet{
    private EmpService empService=new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        String pageCurrent = res.getParameter("pageCurrent");
        String pageSize = res.getParameter("pageSize");
        Page<Employee> allEmp = empService.findPageEmp(Integer.parseInt(pageCurrent), Integer.parseInt(pageSize));
        JsonUtil.printByJSON(resp,allEmp);

    }
}
