<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" language="java"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EL获取域中数据</title>
    <%-- EL表达式
		5. 使用：
		    2. 获取值
		        1. el表达式只能从域对象中获取值
		        2. 语法：
			        1. ${域名称.键名}：从指定域中获取指定键的值
				        * 域名称：
					        1. pageScope		--> pageContext
					        2. requestScope 	--> request
					        3. sessionScope 	--> session
					        4. applicationScope --> application（ServletContext）
				        * 举例：在request域中存储了name=张三
				        * 获取：${requestScope.name}

			        2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

    --%>
</head>
<body>

<%
    // 域中存储数据
    session.setAttribute("name", "李四");
    request.setAttribute("name", "张三");
    session.setAttribute("age", "23");

%>

<h3>EL获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}


${name}
${sessionScope.name}
</body>
</html>
