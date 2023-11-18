package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

import helperclasses.SQLConnection;

public class SignUp extends HttpServlet {
    String SEMAIL, SPASS;

    // STEP 1: DECLARING ORACLE OBJECTS
  
    OraclePreparedStatement ops;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Register</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Servlet Register</h1>");
        SEMAIL = request.getParameter("remail");
        SPASS = request.getParameter("rpass");
        pw.println("<body style=\"background-color: #0E0B0B;\">");
        pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">Fetch and Flex</h1>");

        try { 
       
            SQLConnection obj = new SQLConnection();
            OracleConnection conn;
            conn = obj.connect();
            obj.createUserCreds();
            ops = (OraclePreparedStatement) conn.prepareStatement("INSERT INTO user_creds(EMAIL, PASSWORD) values(?, ?)");
            ops.setString(1, SEMAIL);
            ops.setString(2, SPASS);
            int rowsInserted = ops.executeUpdate();
            if (rowsInserted > 0) {
                pw.println("<h1 style=\"color: white;text-align: center;font-size: 30px;\">User registered successfully</h1>");
                pw.println("<p style=\"color: white; text-align: center; font-size: 16px;\">Please add more details to continue</p>");
                pw.println("<div style=\"text-align: center;\">");
                pw.println("<button style=\"padding: 10px 35px; border-radius: 40px; background-color: #ee6010; color: white; border-color: transparent; font-size: 15px; font-weight: 650;\" onclick=\"window.location.href='./../../Fetch-N-Flex/Pages/user_details.html'\">Add your details</button>");
                pw.println("</div>");


            } else {
                pw.println("<h3>Failed to register user.</h3>");
            }
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            pw.println("<h2 style='color:red'> Error is : " + ex.toString() + "</h2>");
        }
        
        pw.println("</body>");
        pw.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
