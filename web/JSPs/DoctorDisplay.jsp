<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="helperclasses.SQLConnection" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,300;9..40,400&family=Lumanosimo&family=Poppins&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Doctors/Trainers</title>
    <!-- STEP 2: ADDING INTERNAL STYLE FOR TABLE -->
    <style>
        *{
            font-family: 'DM Sans';
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            background-color: black;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            color: #ee6010;
            font-size: 30px;
            margin-top: 2rem;
        }

        table {
            width: 80%;
            margin-top: 1rem;
            border-collapse: collapse;
            overflow: hidden;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            background-color: #2d2a2a;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ee6010;
            color: white;
        }

        th {
            background-color: #1a1a1a;
        }

        td {
            background-color: #363636;
        }

        button {
            padding: 8px 16px;
            border-radius: 4px;
            background-color: #ee6010;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #d54e0a;
        }
    </style>
</head>

<%
    OracleConnection oconn;
    OraclePreparedStatement ops;
    OracleResultSet ors;
    OracleResultSetMetaData orsmd;
    int counter;
    SQLConnection sqlcon = new SQLConnection();
    oconn = sqlcon.connect();
    ops = (OraclePreparedStatement) oconn.prepareStatement("select * from create_doctors");
    ors = (OracleResultSet) ops.executeQuery();
    orsmd = (OracleResultSetMetaData) ors.getMetaData();
%>

<body>
    <h1 style="font-family: 'Comfortaa', sans-serif; margin-bottom: 3rem; font-size: 36px; color: white; text-align: center;margin-top:4rem;">Doctors/Trainers</h1>

    <!-- STEP 1: BASIC STRUCTURE OF A TABLE -->
    <table>
        <thead>
            <tr>
                <!-- STEP 9: BRINGING THE TABLE HEADINGS -->
                <% for (counter = 1; counter <= orsmd.getColumnCount(); counter++) { %>
                    <th><%=orsmd.getColumnName(counter)%></th>
                <% } %>
          
            </tr>
        </thead>
        <tbody>
            <!-- STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS -->
            <% while (ors.next()) { %>
                <tr>
                    <% for (counter = 1; counter <= orsmd.getColumnCount(); counter++) { %>
                        <td><%=ors.getString(counter)%></td>
                    <% } %>
                    
                </tr>
            <% } %>
        </tbody>
    </table>
</body>

<%
    try {
        if (ors != null) {
            ors.close();
        }
        if (ops != null) {
            ops.close();
        }
        if (oconn != null) {
            oconn.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</html>
