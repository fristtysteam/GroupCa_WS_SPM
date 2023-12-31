<%--
  Created by IntelliJ IDEA.
  User: Frist
  Date: 30/12/2023
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<p>Login Form</p>
<form action="controller" method="post">
    <table>
        <tr>
            <td> Username : </td><td> <input name="username" size=30 type="text" required /> </td>
        </tr>
        <tr>
            <td> Password : </td><td> <input name="password" size=30 type="password" required /> </td>
        </tr>
    </table>
    <input type="submit" value="Submit" />

    <input type="hidden" name ="action" value="login" />
</form>

</body>
</html>
