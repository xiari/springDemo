<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>demo工程</title>
    <!-- 插件引入-->
    <script type="text/javascript" src="../../resources/js/jquery.1.9.0.js"></script>
    <script type="text/javascript" src="../../resources/js/handlebars.2.0.0.js"></script>
</head>

<body bgcolor="white">
<div>
    <table>
        <c:forEach items="${students}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.studentName}</td>
                <td>${stu.sex}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <h2>included page:bootstrapDemo.jsp</h2>
    <td><c:out value="${student.id}"/></td>
    <jsp:include page="bootstrapDemo.jsp">
        <jsp:param name="age" value="${student.id}"/>
        <jsp:param name="name" value="${student.studentName}"/>
    </jsp:include>

</div>
</body>
</html>