<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
</head>
<body>
<h1>Something went wrong</h1>
<%

    Object msg = session.getAttribute("errorMessage");

    if(msg != null){
        String error = (String) msg;
%>

<div> <%=error%> </div>
<%

        session.removeAttribute("errorMessage");

    }
%>

<div><a href="index.jsp">Back to index</a></div>
</body>
</html>