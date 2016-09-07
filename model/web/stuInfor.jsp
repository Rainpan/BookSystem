<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
    <link rel="stylesheet" type="text/css" href="styles/common03.css"/>
</head>
<body bgcolor="#d3d3d3">
<div class="contain">
    <div class="contain">
        <table class="listtable" border="1">
            <caption></caption>

            <tr class="listheader">
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>专业</th>
                <th>学院</th>
            </tr>
            <s:iterator value="#request.student">
                <tr>
                    <th><s:property value="学号"/></th>
                    <th><s:property value="姓名"/></th>
                    <th><s:property value="年龄"/></th>
                    <th><s:property value="性别"/></th>
                    <th><s:property value="专业"/></th>
                    <th><s:property value="学院"/></th>
                </tr>
            </s:iterator>
        </table>
    </div>
</div>
</body>
</html>
