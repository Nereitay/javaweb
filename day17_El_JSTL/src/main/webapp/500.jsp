<%@page contentType="text/html;utf-8" pageEncoding="UTF-8" isErrorPage="true" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
<h1>服务器正忙..........</h1>
<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
