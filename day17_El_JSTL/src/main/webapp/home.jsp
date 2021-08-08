<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
<h3>主体信息</h3>

<%
    pageContext.setAttribute("msg", "hello");

    pageContext.getServletContext(); /*application 所有用户间共享数据*/
    pageContext.getRequest();/*request 一次请求访问的多个资源(转发)*/
    pageContext.getResponse();/*response 响应对象*/
    pageContext.getSession();/*session 一次会话的多个请求间*/
    pageContext.getPage();/*page 当前页面(Servlet)的对象  this*/
    pageContext.getOut();/*out 输出对象，数据输出到页面上*/
    pageContext.getServletConfig();/*config Servlet的配置对象*/
    pageContext.getException();/*exception 异常对象，只有在isErrorPage*/
%>


<%
    pageContext.getAttribute("msg");
%>
</body>
</html>
