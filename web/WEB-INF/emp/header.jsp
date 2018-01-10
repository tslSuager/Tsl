<%@ page import="com.tsl.emps.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">

    <div class="header-middle">

        <a class="sitelogo" href="#" title="Go to Start page"></a>
        <div class="sitename">
            <h1><a href="index.html" title="Go to Start page">员工管理系统<span style="font-weight:normal;font-size:50%;">—教学案例</span></a>
            </h1>
            <h2>教育</h2>
        </div>

    </div>

    <div class="header-bottom">

        <div class="nav2">

            <ul>
                <li><a href="index.html">系统首页</a></li>
            </ul>

            <ul>
                <li><a href="#">员工管理<!--[if IE 7]><!--></a><!--<![endif]-->
                    <!--[if lte IE 6]>
                    <table>
                        <tr>
                            <td><![endif]-->
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/emp/list.do?pageCurrent=1&pageSize=6">员工管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/emp/toadd.do">添加员工</a></li>
                    </ul>
                    <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                </li>
            </ul>

        </div>
    </div>


    <div class="header-breadcrumbs">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">用户登录</a></li>

        </ul>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp;

        <c:if test="${!empty loginUser}">
            <span>欢迎你${loginUser.name}<img src="${pageContext.request.contextPath}/upload/${imageName}" id="tu" style="border-radius: 50%;display: inline-block;
        width: 25px;
        height: 25px;"/>，
                <a href="${pageContext.request.contextPath}/user/exit.do">退出</a></span>
        </c:if>
    </div>
</div>
