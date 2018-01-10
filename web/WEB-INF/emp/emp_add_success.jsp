<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <jsp:include page="common.jsp"/>
    <title></title>
    <style type="text/css">
        .err {
            color: orangered;
        }

    </style>
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
            <h1 class="first">说明<br/></h1>


        </div>
        e
        <div class="main-content">

            <h1 class="pagetitle">用户</h1>
            <div class="column1-unit">
                ${fixEmp.ename}添加成功 ,<span id="tiao">2</span>秒后跳转
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>

<script>
    (new function () {
        var scend = 2;
        var ssda = document.getElementById("tiao");
        var s = setInterval(function () {
            scend--;
            ssda.innerHTML = scend;
            if (scend == 0) {
                clearInterval(s);
                window.location.href = "${pageContext.request.contextPath}/emp/list.do?pageCurrent=1&pageSize=6";
            }
        }, 1000)
    })();
</script>

