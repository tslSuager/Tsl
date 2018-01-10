<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
 
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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

<!--[if IE]><style type="text/css"> body {word-wrap: break-word;}</style><![endif]-->

<body>
<div class="page-container">


<jsp:include page="header.jsp"/>


<div class="main">
 
<div class="main-navigation">

<div class="round-border-topright"></div>
<h1 class="first">添加员工<br /></h1>
<p>填写员工信息保存到数据库<br /></p>
 


 
</div>
 
<div class="main-content">
 
<h1 class="pagetitle">添加员工</h1>

 

 
<div class="column1-unit">
<div class="contactform">
            <form method="post" action="${PageContext.request.contextPath}/emp/add.do">
              <fieldset><legend>&nbsp;基本信息&nbsp;</legend>

                <p><label for="name" class="left">姓名:</label>
                   <input type="text" name="name" id="name" class="field" value="" tabindex="1" /></p>
                
                <p><label for="hire_date" class="left">入职时间:</label>
                   <input type="text" name="hireDate" id="hire_date" class="field" value="" tabindex="1" /></p>
                <p><label for="sal" class="left">薪水:</label>
                   <input type="text" name="sal" id="sal" class="field" value="" tabindex="1" /></p>
			
                <p><input type="submit" name="submit" id="submit" class="button" value="添加" tabindex="6" /></p>
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



