<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html
        xmlns="http://www.w3.org/1999/xhtml" lang="en">

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
        #empno{
            background: #bfbfbf;
        }
    </style>
</head>

<!--[if IE]>
<style type="text/css">
    body {
        word-wrap: break-word;
    }</style><![endif]-->
<body>
<div class="page-container">


    <jsp:include page="header.jsp"/>


    <div class="main">

        <div class="main-navigation">

            <div class="round-border-topright"></div>
            <h1 class="first">修改员工<br/></h1>
            <p>修改员工信息并保存<br/></p>


        </div>

        <div class="main-content">

            <h1 class="pagetitle">修改员工信息</h1>


            <div class="column1-unit">
                <div class="contactform">
                    <form method="post"
                          action="${pageContext.request.contextPath}/emp/edit.do?id=${employee.id}"><input type="hidden" name="id" value=""/>
                        <fieldset>
                            <legend>&nbsp;基本信息&nbsp;</legend>
                            <p><label for="empno"
                                      class="left">编号:</label> <input type="text" name="empno" id="empno" class="field readonly"
                                                                      value="${employee.empno}" tabindex="1" readonly="readonly"/></p>
                            <p><label for="ename"
                                      class="left">姓名:</label> <input type="text" name="ename" id="ename" class="field"
                                                                      value="${employee.ename}" tabindex="1"/></p>
                            <p><label for="job"
                                      class="left">岗位:</label> <input type="text" name="job" id="job" class="field"
                                                                      value="${employee.job}" tabindex="1"/></p>
                            <p><label for="mgr"
                                      class="left">经理编号:</label> <input type="text" name="mgr" id="mgr" class="field"
                                                                        value="${employee.mgr}" tabindex="1"/></p>
                            <p><label for="hiredate"
                                      class="left">入职时间:</label> <input type="text" name="hiredate" id="hiredate" class="field"
                                                                        value="${employee.hiredate}" tabindex="1"/></p>
                            <p><label for="sal"
                                      class="left">薪资:</label> <input type="text" name="sal" id="sal" class="field"
                                                                      value="${employee.sal}" tabindex="1"/></p>

                            <p><input type="submit" id="submit" class="button"
                                      value="保存" tabindex="6"/></p>
                        </fieldset>

                    </form>
                </div>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>
</div>

</body>
</html>



