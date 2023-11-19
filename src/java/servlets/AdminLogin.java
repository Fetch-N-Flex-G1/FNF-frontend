package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleConnection;

import helperclasses.SQLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLogin extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_creds WHERE EMAIL=? AND PASSWORD=?";
    
    @Override
    public void init() throws ServletException {
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
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            
            if (resultSet.next()) {
                // Store username in session
                HttpSession session = request.getSession();
                session.setAttribute("username", userEmail);
                System.out.println(session);
                System.out.printf("\u001B[34m%s\u001B[0m", userEmail);
                
                // Redirect to home.html
                response.sendRedirect("../../../Fetch-N-Flex/Pages/Admin_home.html");
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
