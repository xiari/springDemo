<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>学生管理页面</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap.min.css">
    <script type="text/javascript" src="../../resources/js/jquery.1.9.1.js"></script>
    <script type="text/javascript" src="../../resources/js/handlebars.2.0.0.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.3.3.0.js"></script>

</head>
<body bgcolor="white">
<div >
    <form:form class="navbar-form navbar-left"
               enctype="application/x-www-form-urlencoded"
               modelAttribute="student" action="http://localhost:8080/studentManagement/updateStudent" method="POST">
        <div class="form-group">
            <label for="studentId">学号</label>
            <form:input id="studentId" path="id" type="text" value="${student.id}" readonly="readonly" class="form-control"/>
        <br>
            <label for="studentName">姓名</label>
            <form:input id="studentName" path="studentName" type="text" class="form-control"
                   value="${student.studentName}"/>
        <br>
            <label for="studentSex">性别</label>
            <form:input id="studentSex"  class="form-control" path="sex" type="text"  value="${student.sex}"/>
        </div>
        <input type="submit" class="btn btn-primary">Submit</input>
    </form:form>
</div>

<div>
    <%--<c:out value="${pageContext.request.contextPath}">ctx</c:out>--%>
    <%
        String name = request.getServerName();
        out.print("name:" + name);
    %>
</div>
</body>
</html>