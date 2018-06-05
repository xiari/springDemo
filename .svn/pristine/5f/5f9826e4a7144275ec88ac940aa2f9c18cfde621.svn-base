<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <link>
        <link>
        <title>学生管理页面-添加</title>
        <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap.min.css">
        <script type="text/javascript" src="../../resources/js/jquery.1.9.1.js"></script>
        <script type="text/javascript" src="../../resources/js/handlebars.2.0.0.js"></script>
        <script type="text/javascript" src="../../resources/js/bootstrap.min.3.3.0.js"></script>
    </head>
    <body bgcolor="white">
        <div>
            <form:form cssClass="navbar-form navbar-left"
                       modelAttribute="student"
                       name="newAStuentForm"
                       METHOD="post"
                       action="/studentManagement/addStudent">
                <div class="form-group">
                    <div>
                        <label for="studentName">姓名</label>
                        <form:input id ="studentName" path="studentName" cssClass="form-control" />
                    </div>
                    <br>
                    <%--<div>--%>
                        <%--<label for="sex">性别</label>--%>
                        <%--<form:input id ="sex" path="sex" cssClass="form-control"/>--%>
                    <%--</div>--%>

                    <div>
                        <label for="sex">性别</label>
                        <form:select id ="sex" path="sexType" cssClass="form-control">
                            <!--固定值方式-->
                            <%--<form:option value="男"/>--%>
                            <form:option value="--" label="pls select"/>
                            <form:options items="${student.sexList}" itemLabel="sexName" itemValue="sexValue"/>
                        </form:select>
                    </div>

                    <br>
                    <div>
                        <label for="address">地址</label>
                        <form:input id ="address" path="address"  cssClass="form-control"/>
                    </div>
                    <br>

                    <div>
                        <label for="seqNo">序号</label>
                        <form:input id ="seqNo" path="seqNo"  cssClass="form-control"/>
                    </div>
                    <br>
                    <div>
                        <label for="birthday">生日</label>
                        <form:input id = "birthday" path="birthday"  cssClass="form-control"/>
                    </div>
                    <br>
                    <input type="submit" id="submitButton" value="Submit"  cssClass="form-control"/>
                </div>
            </form:form>
        </div>
    </body>
</html>