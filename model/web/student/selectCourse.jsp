<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择课程</title>
    <link rel="stylesheet" type="text/css" href="../styles/common03.css"/>
    <style type="text/css">
        td{
            height:30px;
            width:100px;
        }
    </style>
</head>
<body>
<div class="top"></div>
<div class="contain">

    <form action="sureCourse" method="post">
        <table class="listtable" border="1">
            <caption></caption>

            <tr class="listheader">
                <th>专业</th>
                <th>教工号</th>
                <th>老师</th>
                <th>课程号</th>
                <th>课程</th>
                <th>学分</th>
                <th>选择</th>
            </tr>
            <s:iterator value="#request.course">
                <tr>
                    <th><s:property value="专业"/></th>
                    <th><s:property value="教工号"/></th>
                    <th><s:property value="老师"/></th>
                    <th><s:property value="课程号"/></th>
                    <th><s:property value="课程"/></th>
                    <th><s:property value="学分"/></th>
                    <th><input type="checkbox" value=<s:property value="课程号"/>;<s:property value="教工号"/> name="select" /></th>
                </tr>
            </s:iterator>
        </table>
        <input type="submit">
    </form>
</div>
</body>
</html>
