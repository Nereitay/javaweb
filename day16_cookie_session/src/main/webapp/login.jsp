<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day16_cookie_session/checkCodeServlet?" + new Date().getTime();
            }
        }
    </script>

</head>
<body>
<form action="/day16_cookie_session/loginServlet">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>CheckCode</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="/day16_cookie_session/checkCodeServlet" alt="" id="img"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Login"></td>
        </tr>

    </table>

</form>

<div><%=request.getAttribute("cc_error") == null? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error") == null? "" : request.getAttribute("login_error")%></div>

${requestScope.cc_error}
</body>
</html>
