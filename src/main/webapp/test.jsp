<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>FileUpload</title>
</head>
<body>
<div>
    <form action="http://localhost:8080/uploadPicList" method="post" enctype="multipart/form-data">
        <%--<label>用户名：</label><input type="text" name="name"/><br/>--%>
        <label>序号：</label><input type="text" name="seqNo"/><br/>
        <label>文件</label><input type="file" name="multipartFile"/><br/>
            <%--<label>文件</label><input type="file" name="multipartFile"/><br/>--%>
        <input type="submit" value="提  交"/>
    </form>
</div>

<div>



</div>
</body>
</html>