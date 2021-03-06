<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="zh-CN">
    <head>
        <title>学生管理页面</title>
        <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap-3.3.0/bootstrap.min.css">
        <script type="text/javascript" src="../../resources/js/jquery.1.9.1.js"></script>
        <script type="text/javascript" src="../../resources/js/handlebars.2.0.0.js"></script>
        <script type="text/javascript" src="../../resources/js/bootstrap.min.3.3.0.js"></script>

        <!--采用模板引擎展示数据 -->
        <script id="studentList" type="text/x-handlebars-template">
            {{#each this}}
            <tr>
                <td><input type="checkbox" name="checkBox"></td>
                <td name="studentId" value="{{id}}">{{id}}</td>
                <td name="studentName" value="{{studentName}}">{{studentName}}</td>
                <td name="studentSex" value="{{sex}}" >{{sex}}</td>
                <td>
                    <input type="button" name="updateStudentButton" class="btn btn-default" value="edit"/>
                </td>
            </tr>
            {{/each}}
        </script>
        <script type="text/javascript">
            var studentListHtml = Handlebars.compile($("#studentList").html());
            /**
             * 编辑按钮事件绑定
             */
            function updateStudent() {
                var $updateInputList = $('input[name="updateStudentButton"]');
                $.each($('td[name="studentId"]'),function (index , value) {
                    // bind click
                    var studentId = value.innerHTML;
                    $updateInputList[index].onclick = function () {
                        window.location.href = "/studentManagement/getStudentById?id=" + studentId;
                    }
                });
            }
            /**
             * 删除方式有2种：单个或批量
             */
            function deleteStudentByIds() {
                $('#delete').bind('click',function () {
                    // 获取选中的idList
                    var $checks = $('input[name="checkBox"]:checked').parent().next();
                    if( $checks.length == 0 ){
                        alert('未选中任何项！');
                        return false;
                    }
                    var checkData = new Array();

                    $.each($checks, function (index, value) {
                        checkData.push(value.getAttribute("value"));
                    });
                    // 删除选中的idList
                    $.ajax({
                        url: "/studentManagement/deleteStudentByIdList?idList="+checkData.toString(),
                        dataType: "json",
                        async: false,
                        success: function (data) {
                            // 判断数据返回为空
                            if( $.isEmptyObject(data)){
                                alert("deleteSuccess~");
                            }
                        }
                    });
                    // 重载当前页面
                    initStudentListView();
                });
            }

            /**
             * checkBox事件绑定
             * 实现多选、全选
             * 如果选择行选时，不影响全选按钮；反过来全选按钮选中时，会勾选所有行选；取消全选按钮时，情况所有行选按钮
             */

            function checkBoxCheckEvent() {
                // 行选
                var $singleCheckBoxList = $('input[name="checkBox"]');
                // 全选按钮
                var $allCheckBox = $('input[name="allChecked"]');

                //全选/全不选
                $allCheckBox.bind("click",function(){
                    $singleCheckBoxList.prop("checked",this.checked);
                    //显示删除按钮
/*                    if(this.checked == true){
                       $("input[name='deleteById'").css("display",'block');
                    }else{
                       $("input[name='deleteById'").css("display",'none');
                    }*/
                });
                
            }
            /**
             * 页面展示数据获取
             * @returns {boolean}
             */
            function initStudentListView() {
                $.ajax(
                        {
                            url: "/studentManagement/init",
                            dataType: "json",
                            async: false,
                            success: function (data) {
                                // 判断数据返回为空
                                if( $.isEmptyObject( data )){
                                    $("#studentListId").html("<div> <br> 数据为空 ... <br></div>");
                                } else {
                                    $("#studentListId").html(studentListHtml(data));
                                }
                            }
                        }
                );
                return true;
            };
            $(document).ready(function () {
                // 页面初始化加载完毕后再进行事件绑定，否则事件绑定失败
                initStudentListView();
                updateStudent();
                checkBoxCheckEvent();
                deleteStudentByIds();
            });
        </script>
    </head>
    <body bgcolor="white">
        <div id="student-table" class="container">
            <table id="studentTable" class="table table-hover">
                <thead>
                <tr>
                    <td width="6"><input type="checkbox" name="allChecked"> <label>全选/全不选</label> </td>
                    <td width="6">序号</td>
                    <td width="20">姓名</td>
                    <td width="15">性别</td>
                    <td width="15">操作</td>
                </tr>
                </thead>
                <tbody id="studentListId">
                </tbody>
            </table>
        </div>
        <div class="btn-group">
            <input id="delete" name="deleteById" class="btn btn-primary" value="delete selected "/>
            <a class="btn btn-primary" href='<spring:url value="/studentManagement/loadSaveStudent" htmlEscape="true"/>'>new A one</a>
        </div>
    </body>
</html>