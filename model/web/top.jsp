<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>无标题文档</title>
    <link rel="stylesheet" href="styles/common.css"/>
</head>

<body>
  <div class="page-header">
            <div class="header-banner">
               
            </div>
            <div class="header-title">
              	 欢迎访问选课系统
            	</div>
            <div class="header-quicklink">
               	 欢迎您，<strong>${sessionScope.name}</strong>
                <a href="#">[修改密码]</a>
                <a href="exitServlet" target="_top">[退出]</a>
	        </div>
	        </div>
	</body>
</html>