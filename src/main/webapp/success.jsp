<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/preventForm" method="post" >
    编号：<input name="uId" type="text">
    姓名：<input name="uName" type="text">
    <input type="hidden" name="token" value="${token}">
    <input type="submit" value="查询" >

</form>
<table border="1px">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${user}" var="i">
        <tr>
            <td>${i.uId}</td>
            <td>${i.uName}</td>
            <td>${i.uSex}</td>
            <td>${i.uAge}</td>
            <td>
                <a href="/edit?uId=${i.uId}">修改</a>
                <a href="/delete?uId=${i.uId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="add.jsp">添加用户</a>

<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" multiple="true" name="file">
    <input type="submit" value="提交">
</form>



</body>
</html>
