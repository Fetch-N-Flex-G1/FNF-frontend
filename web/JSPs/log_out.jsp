<%-- 
    Document   : log_out
    Created on : Nov 22, 2023, 2:39:55 PM
    Author     : ujucoco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: #000000;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log Out</title>
    </head>
    <body style="color: #d9570f; text-align: center;">

        <h1>Clearing Session and Logging out</h1>
        <%session.invalidate();%>
        <a href="../index.html" style="color: #d9570f; text-decoration: none; font-size:25px">Log Out</a>

    </body>
</html>
