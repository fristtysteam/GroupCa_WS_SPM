<%@ page import="com.example.groupca_ws_spm.business.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Library!" %>
</h1>
<br/>
<a href="controller">Index</a>

<%
    User u = (User)session.getAttribute("user");
    if(u == null){
%>

<a href="login.jsp">Login</a><br/>
<a href="register.jsp">Register</a>
<%}else{
%>
<div> You are logged in!</div>
<%
    }
%>
</body>
</html>