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
            <h1 class="first">注册说明<br/></h1>

        </div>

        <div class="main-content">

            <h1 class="pagetitle">用户注册</h1>


            <div class="column1-unit">
                <div class="contactform">
                    <form method="post" action="${pageContext.request.contextPath}/user/register.do"
                          enctype="multipart/form-data">
                        <input type="hidden" name="id" value=""/>
                        <fieldset>
                            <legend>&nbsp;基本信息&nbsp;</legend>
                            <p><label for="name" class="left">用户名:</label>
                                <input type="text" name="name" id="name" class="field" value="" tabindex="1"/>
                            </p>

                            <p><label for="password" class="left">密码:</label>
                                <input type="text" name="password" id="password" class="field" value="" tabindex="1"/>
                            </p>
                            <p><label for="name" class="left">上传头像:</label>
                                <input type="file" name="image" id="image" class="field" value="" tabindex="1"/>
                            </p>

                            <p><span class="err">
                                ${errMsg}
                            </span>
                                <input type="submit" name="submit" id="submit" class="button" value="注册" tabindex="6"/>
                            </p>
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

<script>
    (new function () {
        document.getElementById("codeImage").onclick = function () {
            this.src = "${pageContext.request.contextPath}/code/get.do?ab=" + Math.random();
        }

    })();
</script>

