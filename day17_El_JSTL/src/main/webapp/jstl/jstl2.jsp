<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>choose标签</title>
</head>
<body>

<%--
完成数字编号对应星期几的案例
    1. 域中存储一数字
    2. 使用choose标签取出数字   相当于switch申明
    3. 使用when标签做数字判断    相当于case
    4. otherwise标签做其他情况的声明  相当于default
--%>

<%
    request.setAttribute("number", 30);
%>

<c:choose>
    <c:when test="${number == 1}">星期一</c:when>
    <c:when test="${number == 2}">星期二</c:when>
    <c:when test="${number == 3}">星期三</c:when>
    <c:when test="${number == 4}">星期四</c:when>
    <c:when test="${number == 5}">星期五</c:when>
    <c:when test="${number == 6}">星期六</c:when>
    <c:when test="${number == 7}">星期日</c:when>

    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>

</body>
</html>
