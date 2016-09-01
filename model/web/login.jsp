<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        .contain{
            height:300px;
            margin: 0 auto;
            border:1px solid #333;
        }
    </style>
</head>
<body>
    <div class="top"></div>
    <div class="contain">
        <form action="login.action" method="post">
            学号：<input type="text" name="name"/>
            密码：<input type="text" name="pwd"/>
            <input type="submit">
        </form>
        ${requestScope.msg}

    </div>
</body>
</html>
