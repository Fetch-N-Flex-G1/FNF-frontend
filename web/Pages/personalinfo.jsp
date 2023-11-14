<%-- 
    Document   : personalinfo
    Created on : Nov 14, 2023, 2:36:48 PM
    Author     : baishali
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,300;9..40,400&family=Lumanosimo&family=Poppins&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Info</title>
        <!-- STEP 2: ADDING INTERNAL STYLE FOR TABLE -->
        <style>
            *{
                font-family: 'DM Sans';
            }
                table, tr, td
                {
                    padding: 10px;
                    border: 5px solid black;
                    border-collapse: collapse;
                    margin-top:10rem;
                    margin-left:40px;
                    color:white;
                    font-size:25px;
                }
                th {
                    padding: 10px;
                    border: 5px solid black;
                    margin-bottom: 30px;
                    margin-top: 20px;
                    border-collapse: collapse;
                    color: white;
                    font-size: 4rem; /* Added font-size property */
                }

                button{
                    padding: 10px 35px;
                    border-radius: 40px;
                    background-color: #ee6010;
                    color: white;
                    margin-right:10px;
                    border-color: transparent;
                    font-size: 15px;
                    font-weight: 650;
                }
                body{
                    background-color: color;
                }
            </style>
    </head>
    <%!
        // STEP 3: DECLARING OBJECTS AND VARIABLES
        OracleConnection oconn;
        OraclePreparedStatement ops;
        OracleResultSet ors;
        OracleResultSetMetaData orsmd;
        int counter;
    %>
    <%
        try {
            // STEP 4: REGISTRATION OF ORACLE DRIVER
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // STEP 5: INSTANTIATING THE CONNECTION
            oconn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "c##fandf", "database");
            
            // STEP 6: INSTANTIATING THE STATEMENT OBJECT
            ops = (OraclePreparedStatement) oconn.prepareStatement("select * from user_details");
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet) ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData) ors.getMetaData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    %>
    <body style="background-color: black">
        <p style="text-align: center; color: #ee6010; font-size: 40px; font-weight: bold; margin-top:5rem;
">PERSONAL INFO</p>
        <!-- STEP 1: BASIC STRUCTURE OF A TABLE -->
        <table>
    <tbody>
        <% while (ors.next()) { %>
            <tr>
                <%
                for (counter = 1; counter <= orsmd.getColumnCount(); counter++) {
                    String columnName = orsmd.getColumnName(counter);
                    String columnValue = ors.getString(counter);
                %>
                    <tr>
                        <td><strong><%= columnName %>:</strong></td>
                        <td><%= columnValue %></td>
                    </tr>
                <%
                }
                %>
                <tr>
                    <td colspan="2">
                        <button onclick="editRecord('<%=ors.getString(1)%>')">Edit</button>
                    </td>
                </tr>
            </tr>
        <% } %>
    </tbody>
</table>
