package com.tsl.emps.action;

import com.tsl.emps.serviece.UserService;
import com.tsl.emps.serviece.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/doasd")
public class AjaxServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了我");
        // 指定允许其他域名访问
        resp.setHeader("Access-Control-Allow-Origin", "*");
// 响应类型
        resp.setHeader("Access-Control-Allow-Methods", "POST");
// 响应头设置
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        PrintWriter writer = resp.getWriter();
        writer.print(userService.findUserByName("tsl").toString());
        writer.flush();
        writer.close();
    }


}
