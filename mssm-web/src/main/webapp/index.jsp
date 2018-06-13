<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2018/6/6
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BEGIN</title>
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        function fun1() {
            var params = '{"name":"Note"}';
            $.ajax({
                url : "${pageContext.request.contextPath}/ajaxTest.action",
                data : params,
                contentType : "application/json;charset=UTF-8",
                type : "post",
                dataType : "json",
                success: function (data) {

                }
            });
        }
        function fun2() {
            var params = '{"name":"Note"}';
            $.ajax({
                url : "${pageContext.request.contextPath}/ajaxJsonParamTest.action",
                data : params,
                contentType : "application/json;charset=UTF-8",
                type : "post",
                dataType : "json",
                success : function (data) {
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
    <a href="/test/find.action">查询</a>
    <form action="${pageContext.request.contextPath}/find.action" method="post">
        Username:<input name="username" type="text">
        Password:<input name="password" type="password">
        Date:<input name="date" value="2018-6-7 09:23:55">
        <input type="hidden" name="content" value="This is my content">
        <button type="submit">Submit</button>
    </form>
    <br>
    <%--List参数绑定测试--%>
    <form action="${pageContext.request.contextPath}/list.action">
        <c:forEach var="i" begin="0" end="4">
            <input type="text" name="ids" value="${i}"/>
        </c:forEach>
        <button type="submit">Submit</button>
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/userTest.action">
        <input type="text" name="userList[0].username" value="G1"/>
        <input type="text" name="userList[0].password" value="P1">
        <input type="text" name="userList[1].username" value="G2"/>
        <input type="text" name="userList[1].password" value="P2">
        <button type="submit">Submit</button>
    </form>
    <hr>
    <%--上传文件--%>
    <form action="${pageContext.request.contextPath}/file.action" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="submit">Submit</button>
    </form>

    <button type="button" onclick="javascript:fun1()">发送</button>
    <button type="button" onclick="javascript:fun2()">Fun2</button>
</body>
</html>
