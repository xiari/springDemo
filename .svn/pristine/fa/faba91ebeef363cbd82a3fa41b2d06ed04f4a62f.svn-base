<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XYY78
  Date: 2016/9/7
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>demo工程</title>
    <!-- 插件引入-->
    <script type="text/javascript" src="../../resources/js/jquery.1.9.0.js"></script>
    <script type="text/javascript" src="../../resources/js/handlebars.2.0.0.js"></script>


    <script id="tpl" type="text/x-handlebars-template">
  </script>
    <script type="text/javascript">
        function showStudentList() {
            $.ajax(
                    {
                        url: "http://localhost:9090/showStudentList",
                        async: false,
                        dataType: "json",
                        success: function (data) {
                            $('#studList').empty();   //清空resText里面的所有内容
                            var html = '';
                            $.each(data, function (commentIndex, comment) {
                                html += '<td>' + comment['id']
                                        + ':\t' + comment['studentName']
                                        + '</td>';
                            });
                            $('#studList').html(html);
                        }
                    }
            );
        }
    </script>
</head>
<body>
<div>
    <li><a href="javascript:" onclick="showStudentList();">展示同学信息</a></li>
</div>
<div id="studList"></div>
</body>
</html>