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
                    margin: 0 auto;
                    border: 5px solid #ee6010;
                    border-collapse: collapse;
                    color:white;
                    border-radius;
                }
                th
                {
                    padding: 10px;
                    border: 5px solid #ee6010;;
                    border-collapse: collapse;
                    color: white;
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
        <h1 style="text-align: center; color: #ee6010; font-size: 30px;">PERSONAL INFO</h1>
        <!-- STEP 1: BASIC STRUCTURE OF A TABLE -->
        <table>
            <thead>
                <tr>
                    <!-- STEP 9: BRINGING THE TABLE HEADINGS -->
                    <%
                        for (counter = 1; counter <= orsmd.getColumnCount(); counter++) {
                    %>
                        <th><%=orsmd.getColumnName(counter)%></th>
                    <%
                        }
                    %>
                    <th>ACTION</th>
                </tr>
            </thead>
            <tbody>
                <!-- STEP 10: BRINGING ALL THE RECORDS AND DISPLAYING AS TABLE ROWS -->
                <%
                    while (ors.next()) {
                %>
                    <tr>
                        <%
                            for (counter = 1; counter <= orsmd.getColumnCount(); counter++) {
                        %>
                            <td><%=ors.getString(counter)%></td>
                        <%
                            }
                        %>
                        <td>
                            <button onclick="editRecord('<%=ors.getString(1)%>')">Edit</button>
                            <button onclick="deleteRecord('<%=ors.getString(1)%>')">Delete</button>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="<%=orsmd.getColumnCount()%+1%>">&copy; FETCH-N-FLEX</th>
                </tr>
            </tfoot>
        </table>
        <%
            // STEP 11: CLOSING THE CONNECTIONS
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
    </body>
</html>

