<%--
  Created by IntelliJ IDEA.
  User: petersuen
  Date: 11/28/17
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学员信息列表</h1>
<a href="toAdd">添加学员</a>
<table border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>电话</td>
        <td>email</td>
        <td>班级</td>
    </tr>
    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.gender}</td>
            <td>${s.age}</td>
            <td>${s.telephone}</td>
            <td>${s.email}</td>
            <td>${s.classes.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
