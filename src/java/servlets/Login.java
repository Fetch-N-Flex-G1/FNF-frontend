/**package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helperclasses.SQLConnection;
import oracle.jdbc.OracleConnection;

public class Login extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_credentials WHERE EMAIL=? AND PASSWORD=?";

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String userEmail = request.getParameter("SEMAIL");
        String userPassword = request.getParameter("SPASS");

        try {
            SQLConnection scon = new SQLConnection();
            OracleConnection connection = scon.connect();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_QUERY);


            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pw.println("<html><body>");
                pw.println("<h3>Welcome User to our site</h3>");
                RequestDispatcher rd1 = request.getRequestDispatcher("./index.html");
                rd1.include(request, response);
                pw.println("<form method=\"post\" action=\"login.html\">");
                pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
                pw.println("</form>");
                pw.println("</body></html>");

            } else {
                pw.println("<html><body>");
                pw.println("<center><h3>Invalid username/password. Enter Correct username/password</h3></center>");
                RequestDispatcher rd2 = request.getRequestDispatcher("./login.html");
                rd2.include(request, response);
                pw.println("</body></html>");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
* */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;

import helperclasses.SQLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_creds WHERE EMAIL=? AND PASSWORD=?";
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String userEmail = request.getParameter("SEMAIL");
            String userPassword = request.getParameter("SPASS");
            
            SQLConnection sqlcon = new SQLConnection();
            
            OracleConnection connection = null;
            try {
                connection = sqlcon.connect();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SELECT_QUERY);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            
            if (resultSet.next()) {
                // Redirect to home.html
                response.sendRedirect("../../../Fetch-N-Flex/Pages/home.html");
                
                pw.println("</body></html>");
                
            } else {
                pw.println("<html><body>");
                pw.println("<center><h3>Invalid username/password. Enter Correct username/password</h3></center>");
                RequestDispatcher rd2 = request.getRequestDispatcher("./login.html");
                rd2.include(request, response);
                pw.println("</body></html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
        
}