<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

        <form action="" method="post">
            <input type="submit">
        </form>

        <table border="1">
            <tr>
                <td>课程号</td>
                <td>课程</td>
                <td>学分</td>
            </tr>
            <s:iterator value="#request.class">
                <tr>
                    <td><s:property value="claId"/></td>
                    <td><s:property value="claName"/></td>
                    <td><s:property value="claCredit"/></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</body>
</html>
