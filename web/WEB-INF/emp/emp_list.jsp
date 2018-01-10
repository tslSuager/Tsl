<%@ page import="com.tsl.emps.domain.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
</head>

<!--[if IE]>
<style type="text/css"> body {
    word-wrap: break-word;
}</style><![endif]-->


<%--<style>--%>
    <%--#tu {--%>
        <%--display: inline-block;--%>
        <%--width: 25px;--%>
        <%--height: 25px;--%>
        <%--border-radius: 50%;--%>
    <%--}--%>
<%--</style>--%>
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

            <h1 class="pagetitle">员工列表<a href="${pageContext.request.contextPath}/WEB-INF/emp/emp_add.jsp" id="addemp">添加</a>
            </h1>
            <div class="column1-unit">
                <table>
                    <tr>
                        <th class="top" scope="col"><input type="checkbox" id="allcheck"><a href="javascript:void (0)"
                                                                                            id="jsdel">删除</a></th>
                        <th class="top" scope="col">员工编号<br/></th>
                        <th class="top" scope="col">姓名</th>
                        <th class="top" scope="col">工资<br/></th>
                        <th class="top" scope="col">入职时间</th>
                        <th class="top" scope="col">操作</th>
                    </tr>
                    <c:forEach items="${allEmp.data}" var="e">
                        <tr>
                            <td><input type="checkbox" class="checkdel"><input type="hidden" class="hid"
                                                                               value="${e.id}"></td>
                            <th scope="row">${e.empno}</th>
                            <td>${e.ename}</td>
                            <td>${e.sal}</td>
                            <td>${e.hiredate}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/emp/show.do?id=${e.id}">详情</a>
                                <a href="${pageContext.request.contextPath}/emp/del.do?id=${e.id}">删除</a>
                                <a href="${pageContext.request.contextPath}/emp/toedit.do?id=${e.id}">修改</a>
                            </td>
                        </tr>

                    </c:forEach>
                </table>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                    class="pagefooter">当前第${allEmp.pageCurrent}页，共${allEmp.pageCount}页</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="pagefooter">
                   <a href="${pageContext.request.contextPath}/emp/list.do?pageCurrent=${allEmp.prevPage}&pageSize=${allEmp.pageSize}">上一页</a> |
                                <a href="${pageContext.request.contextPath}/emp/list.do?pageCurrent=${allEmp.nextPage}&pageSize=${allEmp.pageSize}">下一页</a>
                </span>
            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>

<script>
    (function () {
        var jsdel = document.getElementById("jsdel");
        var allcheck = document.getElementById("allcheck");
        var checks = document.getElementsByClassName("checkdel");
        var hids = document.getElementsByClassName("hid");
        var ids = "";
        jsdel.onclick = function () {
            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked) {
                    if (ids == "") {
                        ids = ids + hids[i].value;
                    } else {
                        ids = ids + "," + hids[i].value;
                    }
                }
            }
            if (ids == "") {

            } else {
                window.location.href = "${pageContext.request.contextPath}/emp/delchecked.do?ids=" + ids;
                ids = "";
            }

        }
        allcheck.onclick=function () {
            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked) {
                    checks[i].checked=false;
                }else {
                    checks[i].checked=true;
                    allcheck.checked=true;
                }
            }
        }
        for (var i = 0; i < checks.length; i++) {
            checks[i].onclick=function () {
                if (this.checked) {
                    allcheck.checked=true;
                }
                var all=false;
                for (var i = 0; i < checks.length; i++) {
                    if (checks[i].checked) {
                        all=true;
                       break;
                    }
                }
                if (!all) {
                    allcheck.checked=false;
                }
            };
        }

    })();


</script>

