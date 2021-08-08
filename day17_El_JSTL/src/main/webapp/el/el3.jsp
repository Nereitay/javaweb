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
    <title>EL获取对象中数据</title>
    <%-- EL表达式
		5. 使用：
		    2. 获取值
		        1. el表达式只能从域对象中获取值
		        2. 语法：
			        3. 获取对象、List集合、Map集合的值
				        1. 对象：${域名称.键名.属性名}
					        * 本质上会去调用对象的getter方法

				        2. List集合：${域名称.键名[索引]}

				        3. Map集合：
					        * ${域名称.键名.key名称}
					        * ${域名称.键名["key名称"]}

    --%>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBir(new Date());

    request.setAttribute("u", user);

    List<Object> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add(user);

    request.setAttribute("list", list);

    Map<Object, Object> map = new HashMap<>();
    map.put("sname", "李四");
    map.put("gender", "男");
    map.put("user", user);

    request.setAttribute("map", map);
%>

<h3>EL获取对象中的值</h3>
${requestScope.u}
<br>
<%--
    * 通过的是对象的属性来获取
        * setter或getter方法
--%>

${requestScope.u.name} <br>
${u.age} <br>
${u.bir} <br>
${u.bir.month} <br>

${u.birStr} <br>

<h3>el获取list值</h3>
${list} <br>
${list[0]} <br>
${list[1]} <br>
${list[10]} <br>

${list[2].name}

<h3>el获取map值</h3>
${map.gender} <br>
${map["gender"]} <br>
${map.user.name} <br>
</body>
</html>
