<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2018/10/21
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update" method="post">
编号:<input name="uId" readonly="readonly" type="text" value="${user.uId}"><br>
姓名:<input name="uName" type="text" value="${user.uName}"><br>
性别:<input name="uSex" type="text" value="${user.uSex}"><br>
年龄:<input name="uAge" type="text" value="${user.uAge}"><br>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
