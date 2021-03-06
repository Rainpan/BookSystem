<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询已选课程</title>
    <link rel="stylesheet" type="text/css" href="../styles/common03.css"/>
</head>
<body>
<div class="contain">
    <form action="backCourse.action" method="post">
        <table class="listtable" border="1">
            <tr class="listheader">
                <th>课程编号</th>
                <th>课程</th>
                <th>学分</th>
                <th>选择</th>
            </tr>
                <s:iterator value="#request.course">
                    <tr>
                        <th><s:property value="课程编号"/></th>
                        <th><s:property value="课程"/></th>
                        <th><s:property value="学分"/></th>
                        <th><input type="checkbox" value=<s:property value="课程编号"/> name="select" /></th>
                    </tr>
                </s:iterator>
        </table>
        <input type="submit" value="随便提交">
    </form>
</div>
</body>
</html>
