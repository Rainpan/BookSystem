<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>无标题文档</title>
    <script type="text/javascript" src="jquery/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/common04.css"/>
    <script type="text/javascript">
        $(function () {
            $(".sidebar-grouptitle1").click(function () {
                $(".sidebar-menu1").toggle();
            });

            $(".sidebar-grouptitle2").click(function () {
                $(".sidebar-menu2").toggle();
            });

            $(".sidebar-grouptitle3").click(function () {
                $(".sidebar-menu3").toggle();
            });
        })
    </script>
</head>
<body>
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle1">个人中心</div>
                    <ul class="sidebar-menu1">
                        <li class="sidebar-menuitem"><a href="queryInfor.action" target="main">个人信息管理</a></li>
                    </ul>
                </div>
              
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle2">选课管理</div>
                    <ul class="sidebar-menu2">
                        <li class="sidebar-menuitem"><a href="selectCourse.action" target="main">正选</a></li>
                        <li class="sidebar-menuitem"><a href="queryCourse.action" target="main">正选结果</a></li>
                        <li class="sidebar-menuitem"><a href="queryCourse.action" target="main">退选</a></li>
                    </ul>
                </div>              
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle3">意见</div>
                    <ul class="sidebar-menu3">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp" target="main">管理员反馈</a></li>
                    </ul>
                </div>
            </div>
</body>
</html>
