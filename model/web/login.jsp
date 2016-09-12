<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
        <title>学生选课系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
            <div class="page-content">
                <div class="content-nav">
                   	<h1>学生选课系统</h1>
                </div>
                <form action="login.action" method="post">
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号ID:</td>
                                <td>
                                    <input id="accountname" name="id"type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="new" name="pwd" type="password" />
                                </td>
                            </tr>
                            <tr>
                            <td>选择登录人员属性:</td>
                            <td>
                            <select name="type">
                            <option value="1">学生</option>
                            <option value="2">老师</option>
                            <option value="3">管理员</option>
                            </select><br>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="登录" class="clickbutton">
                                </td>
                            </tr>
                        </table>
                        ${requestScope.msg}
                    </fieldset>
                </form>
            </div>
    </body>
</html>