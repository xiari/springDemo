<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body >
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/passport/homepage">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/passport/logout">点击退出</a><br/>
</shiro:user>
</body>
</html>
