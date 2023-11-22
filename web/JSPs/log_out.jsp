<%-- 
    Document   : log_out
    Created on : Nov 22, 2023, 2:39:55 PM
    Author     : ujucoco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clearing Session and Logging out</h1>
        <%session.invalidate();%>
        <a href="../index.html">Log Out</a>
    </body>
</html>
