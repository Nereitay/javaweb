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
    <title>if标签</title>
</head>
<body>

<%--
c:if标签
    1. 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用
    2. 注意：
       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签

--%>
<c:if test="true">
    <h1>我是真...</h1>
</c:if>
<br>

<%
    //判断request域中的一个集合list是否为空，如果不为null则显示遍历集合

    List<Object> list = new ArrayList<>();
    list.add("aaaa");
    request.setAttribute("list", list);
    request.setAttribute("number", 3);
    
%>

<c:if test="${not empty list}">
    遍历集合....
</c:if>
<br>

<c:if test="${number % 2 != 0}">
    ${number}为奇数
</c:if>

<c:if test="${number % 2 == 0}">
    ${number}为偶数
</c:if>
</body>
</html>
