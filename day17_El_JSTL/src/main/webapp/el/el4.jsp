<%@ page import="es.kiwi.domain.User" %>
<%@ page import="java.util.*" %>
<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" language="java"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EL隐式对象</title>
    <%-- * el表达式中有11个隐式对象
		* pageContext：
			* 获取jsp其他八个内置对象
				* ${pageContext.request.contextPath}：动态获取虚拟目录
    --%>
</head>
<body>

${pageContext.request} <br>
<h4>在jsp页面动态获取虚拟目录</h4>
${pageContext.request.contextPath}


<%
    response.sendRedirect(request.getContextPath() + "");
%>

</body>
</html>
