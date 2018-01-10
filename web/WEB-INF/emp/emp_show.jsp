<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
    <style>
        #tu {
            display: inline-block;
            width: 25px;
            height: 25px;
            border-radius: 50%;
        }
    </style>
</head>

<!--[if IE]>
<style type="text/css"> body {
    word-wrap: break-word;
}</style><![endif]-->

<body>
<div class="page-container">


    <jsp:include page="header.jsp"/>


    <div class="main">

        <div class="main-navigation">

            <div class="round-border-topright"></div>
            <h1 class="first">列表说明<br/></h1>
            <p>表格内显示所有员工信息</p>


        </div>

        <div class="main-content">

            <h1 class="pagetitle">员工详情-${employee.ename}</h1>


            <div class="column1-unit">
                <table>
                    <tr>
                        <td colspan="4">员工信息详情</td>
                    </tr>
                    <tr>
                        <td>编号</td>
                        <td>${employee.empno}</td>
                        <td>姓名</td>
                        <td>${employee.ename}</td>
                    </tr>
                    <tr>
                        <td>岗位</td>
                        <td>${employee.job}</td>
                        <td>经理编号</td>
                        <td>${employee.mgr}</td>
                    </tr>
                    <tr>
                        <td>入职时间</td>
                        <td>${employee.hiredate}</td>
                        <td>工资</td>
                        <td>${employee.sal}</td>
                    </tr>
                    <tr>
                        <td>绩效</td>
                        <td>${employee.comm}</td>
                        <td>部门编号</td>
                        <td>${employee.deptno}</td>
                    </tr>
                </table>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>



