<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color: #9687ff;}</style>
</head>
<body>
<div class="error">${error}</div>
    <form action="${pageContext.request.contextPath}/passport/login" method="POST">
<%--<form action="https://localhost:8443/cas-server-webapp-4.0.0-RC3/login?service=https://localhost:9443/cas" method="post">--%>
        用户名：<input type="text" name="username" /><br/>
        　密码：<input type="password" name="password"/><br/>
        下次自动登录：<input type="checkbox" name="rememberMe" value="true"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>