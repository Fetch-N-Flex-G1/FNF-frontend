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
        body {
            background-color: #191B1D !important;
            color: #fff;
            font-family: 'DM Sans', sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            text-align: center;
            color: #ee6010;
            font-size: 30px;
            margin-top: 4rem;
            padding: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 2px solid #444;
        }

        th {
            background-color:  #2c3439;
            color: #ee6010;
            font-size: 22px;
        }

        tr:hover {
            background-color: #1E2227;
        }

        button {
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #ee6010;
            color: #fff;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #ff7f50;
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
            position: absolute;
            bottom: 0;
            width: 100%;
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
    <h1 style="font-family: 'Comfortaa', sans-serif; margin-bottom: 3rem; font-size: 40px; color: white; text-align: center;margin-top:4rem;">Doctors & Trainers</h1>

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
