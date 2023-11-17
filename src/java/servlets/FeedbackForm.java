package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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

public class FeedbackForm extends HttpServlet {
    String SNAME, SEMAIL, Sfeedback;

    // STEP 1: DECLARING ORACLE OBJECTS
  
    OraclePreparedStatement ops;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Feedback</title>");
        pw.println("</head>");
        pw.println("<body>");
        SNAME= request.getParameter("name");
        SEMAIL = request.getParameter("email");
        Sfeedback= request.getParameter("message");
        pw.println("<body style=\"background-color: #0E0B0B;\">");
        pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">FETCH AND FLEX</h1>");

        try { 
       
            SQLConnection obj = new SQLConnection();
            OracleConnection conn;
            conn = obj.connect();
            obj.createFeedback();
            ops = (OraclePreparedStatement) conn.prepareStatement("INSERT INTO feedback(NAME,EMAIL,FEEDBACK) values(?,?,?)");
            ops.setString(1, SNAME);
            ops.setString(2, SEMAIL);
            ops.setString(3, Sfeedback);
            int rowsInserted = ops.executeUpdate();
            if (rowsInserted > 0) {
                pw.println("<h1 style=\"color: white;text-align: center;font-size: 30px;\">Feedback Submitted!</h1>");
            } else {
                pw.println("<h3>Failed to submit.</h3>");
            }
            
            conn.close();
            
//
        } catch (SQLException ex) {
            Logger.getLogger(EmergencyCon.class.getName()).log(Level.SEVERE, null, ex);
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