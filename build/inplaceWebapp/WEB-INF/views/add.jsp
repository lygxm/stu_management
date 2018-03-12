
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf"
           uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <link href="static/css/main.css" rel="stylesheet"  type="text/css"/>
</head>
<body>
    <a href="#" onclick="javascript:logout()">Logout</a>
    <sf:form modelAttribute="student"
             method="post" action="add">
        Name<sf:input path="name" />
        <sf:errors path="name" cssClass="error"/> <br>
        Gender<sf:input path="gender" /> <sf:errors path="gender" cssClass="error"/><br>
        Age<sf:input path="age" /> <sf:errors path="age" cssClass="error"/><br>
        Telephone<sf:input path="telephone" /> <sf:errors path="telephone" cssClass="error"/><br>
        Email<sf:input path="email" /> <sf:errors path="email" cssClass="error"/><br>
        Classes

        <sf:select path="classes.id">
            <c:forEach items="${classesList}" var="c">
                <sf:option value="${c.id}">${c.name}</sf:option>
            </c:forEach>
        </sf:select>


        <sf:errors path="classes.id" cssClass="error"/><br>
        <input type="submit" value="保存" />
        <input type="button" value="返回" onclick="window.location.href='/stu_management'"/>
    </sf:form>
    <%--<form action="add" method="post">--%>
        <%--<input name="name"/><br>--%>
        <%--<input name="gender"/><br>--%>
        <%--<input name="age"/><br>--%>
        <%--<input name="telephone"/><br>--%>
        <%--<input name="email"/><br>--%>
        <%--<select name="classes.id">--%>
            <%--<c:forEach items="${classes}" var="c">--%>
                <%--<option value="${c.id}">${c.name}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
        <%----%>
        <%--<input type="submit" value="保存" />--%>
        <%--<input type="button" value="返回" onclick="window.location.href='/stu_management'"/>--%>
    <%--</form>--%>
</body>
<script>
    function logout() {
        var form = document.createElement("from");
        document.body.appendChild(form);
        form.method="post";
        form.action="/logout";
        form.submit();
    }
</script>
</html>
