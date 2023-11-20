<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Set"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:opsz,wght@9..40,300;9..40,400&family=Lumanosimo&family=Poppins&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Personal Info</title>
    <style>
        * {
            font-family: 'DM Sans';
        }

        table, tr, td {
            padding: 10px;
            border: 5px solid black;
            border-collapse: collapse;
            color: white;
            font-size: 25px;
            margin: 0 auto;
        }

        th {
            padding: 10px;
            border: 5px solid black;
            margin-bottom: 30px;
            margin-top: 20px;
            border-collapse: collapse;
            color: white;
            font-size: 4rem;
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

        body {
            background-color: color;
        }

        p {
            margin-bottom: 6rem;
        }

        .profile-image-container {
            border-radius: 50%;
            overflow: hidden;
            width: 150px;
            height: 150px;
            margin: 0 auto;
            display: block;
            margin-bottom: 20px;
            position: relative;
        }

        .profile-image-container img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .edit-icon {
            position: absolute;
            bottom: 5px;
            right: 5px;
            cursor: pointer;
            color: white;
        }

        input[type="file"] {
            display: none;
        }
    </style>
</head>

<body style="background-color: black">
    <p style="text-align: center; color: #ee6010; font-size: 40px; font-family: Comfortaa; font-weight: bold; margin-top: 5rem; font-weight: 600;">PERSONAL INFORMATION</p>
    
    <table>
        <tbody>
            <%  HttpSession userSession = request.getSession();
            
                Map<String, String> column_head = new LinkedHashMap();
                column_head.put("F_NAME", "First Name");
                column_head.put("L_NAME", "Last Name");
                column_head.put("EMAIL", "Email");
                column_head.put("PH_NO", "Phone Number");
                column_head.put("ADDRESS", "Address");
                column_head.put("GENDER", "Gender");
                
                Set<String> keys = column_head.keySet();
                System.out.println(column_head);
                for (String key : keys)
                {
                %>
                    <tr>
                        <%
                            String columnValue = (String) session.getAttribute(key);
                        %>
                            <tr>
                                <td><strong><%= column_head.get(key) %> :</strong></td>
                                <td><%= columnValue %></td>
                            </tr>
                        <%
//                        }
                        %>
                        
                    </tr>
                <% } %>
                <<tr><td colspan="2">
                                <button>Edit</button>
                            </td></tr>
                
                
        </tbody>
    </table>
    <img src="../images/doggy.png" alt="Dog Image" style="position: fixed; bottom: 0; right: 0;">
</body>
</html>
