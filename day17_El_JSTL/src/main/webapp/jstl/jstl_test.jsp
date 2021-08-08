<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" %>
<%@ page import="es.kiwi.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test</title>
    <%--
         练习：
	* 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中
    --%>
</head>
<body>
<%
    List<User> list = new ArrayList<>();
    list.add(new User("张三", 23, new Date()));
    list.add(new User("李四", 24, new Date()));
    list.add(new User("王五", 25, new Date()));

    request.setAttribute("list", list);
%>

<table border="1" align="center" width="500">
    <tr bgcolor="#d3d3d3">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="#fa8072">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

        <c:if test="${s.count % 2 != 0}">
            <tr bgcolor="#8fbc8f">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>

</table>
</body>
</html>
