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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleResultSetMetaData;

public class Login extends HttpServlet {
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
            
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            
            SQLConnection sqlcon = new SQLConnection();
            OracleConnection oconn = null;
            try {
                oconn = sqlcon.connect();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = oconn.prepareStatement(SELECT_QUERY);
                preparedStatement.setString(1, userEmail);
                preparedStatement.setString(2, userPassword);
                ResultSet resultSet = preparedStatement.executeQuery();
//                HttpSession user_details = request.getSession();
//                String query = "SELECT * FROM user_details WHERE EMAIL = ?";
//                ops = (OraclePreparedStatement) oconn.prepareStatement(query);
//                ops.setString(1, userEmail);
                
                
                if (resultSet.next()) {
                    // Store username in session
                    HttpSession session = request.getSession();
                    session.setAttribute("username", userEmail);
                    System.out.println(session);
                    System.out.printf("\u001B[34m%s\u001B[0m", userEmail);
                    setUserSessionInfo(userEmail,request);
//                    System.out.println("Setting user session info");
                    // Redirect to home.html
//                    ors = (OracleResultSet) ops.executeQuery();
//                    orsmd = (OracleResultSetMetaData) ors.getMetaData();
//                    if (ors.next()) {
//                        for (int counter = 1; counter < orsmd.getColumnCount(); counter++) {
//                                        String column_name = orsmd.getColumnName(counter);
//                                        String column_value = ors.getString(counter);
//                                        user_details.setAttribute(column_name, column_value);
//
//                        }
//                    }
                    response.sendRedirect("../../../Fetch-N-Flex/JSPs/home.jsp");
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
        
    
        void setUserSessionInfo(String user_email, HttpServletRequest request) throws SQLException{
            OraclePreparedStatement ops;
            OracleResultSet ors;
            OracleResultSetMetaData orsmd;
            
            SQLConnection sqlcon = new SQLConnection();
            OracleConnection oconn = sqlcon.connect();
            
            HttpSession user_details = request.getSession();
//            String loggedInEmail = (String) userSession.getAttribute("username");
            
            // Execute SQL query
            String query = "SELECT * FROM user_details WHERE EMAIL = ?";
            ops = (OraclePreparedStatement) oconn.prepareStatement(query);
            ops.setString(1, user_email);
            ors = (OracleResultSet) ops.executeQuery();
            
            // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
            orsmd = (OracleResultSetMetaData) ors.getMetaData();
            if (ors.next()) {
                        for (int counter = 1; counter < orsmd.getColumnCount(); counter++) {
                                        String column_name = orsmd.getColumnName(counter);
                                        String column_value = ors.getString(counter);
                                        user_details.setAttribute(column_name, column_value);

                        }
            }
            
        
    } 
}
