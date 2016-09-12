<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询已选课程</title>
    <link rel="stylesheet" type="text/css" href="../styles/common03.css"/>
</head>
<body>
<div class="contain">
    <table class="listtable" border="1">
        <tr class="listheader">
            <th>老师编号</th>
            <th>老师名字</th>
            <th>课程编号</th>
            <th>课程名字</th>
            <th>学生学号</th>
            <th>学生名字</th>
            <th>学生专业</th>
        </tr>
        <s:iterator value="#request.ofStu">
            <tr>
                <th><s:property value="老师编号"/></th>
                <th><s:property value="老师名字"/></th>
                <th><s:property value="课程编号"/></th>
                <th><s:property value="课程名字"/></th>
                <th><s:property value="学生学号"/></th>
                <th><s:property value="学生名字"/></th>
                <th><s:property value="学生专业"/></th>
            </tr>
        </s:iterator>
    </table>
</div>
</body>
</html>
