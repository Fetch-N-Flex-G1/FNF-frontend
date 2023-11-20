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
        <title>Emergency Contacts</title>
        <!-- STEP 2: ADDING INTERNAL STYLE FOR TABLE -->
       <style>
        * {
            font-family: 'DM Sans';
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: color; /* Replace 'color' with an actual color value */
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        h1 {
            font-size: 5rem;
            font-family: Comfortaa;
            text-align: center;
            color: #ee6010;
            margin-top: 2rem;
        }

        table {
            border-collapse: separate;
            border-spacing: 0;
            width: 80%;
            margin: auto;
            border-radius: 30px;
            overflow: hidden;
            margin-top: 2rem;
        }

        tr, td {
            padding: 10px;
            border: 1px solid #ee6010;
            text-align: center;
            color: white;
        }

        th {
            padding: 10px;
            border: 1px solid #ee6010;
            color: white;
            background-color: #ee6010;
        }

        button {
            padding: 10px 35px;
            border-radius: 40px;
            background-color: #ee6010;
            color: white;
            margin-right: 10px;
            border-color: transparent;
            font-size: 15px;
            font-weight: 650;
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
            // STEP 4: REGISTRATION OF ORACLE DRIVER
            SQLConnection sqlcon = new SQLConnection();
            
            // STEP 5: INSTANTIATING THE CONNECTION
            oconn = sqlcon.connect();
            
            // STEP 6: INSTANTIATING THE STATEMENT OBJECT
            ops = (OraclePreparedStatement) oconn.prepareStatement("select * from contacts");
            
            // STEP 7: FILLING UP THE DATABASE RECORDS IN A TEMPORARY CONTAINER
            ors = (OracleResultSet) ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData) ors.getMetaData();
        
    %>
    <body style="background-color: black">
        <h1 style="text-align: center; color: #ee6010; font-size: 30px; margin-top: 4rem;">Emergency Contacts</h1>
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
                    </tr>
                <%
                    }
                %>
            </tbody>
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
