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

public class AdminDoctorAdd extends HttpServlet {
    String SNAME, STYPE, SNUM, SADD, STIME;

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
        pw.println("<title>Add Doctors</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Servlet Register</h1>");
        SNAME= request.getParameter("rname");
        STYPE=request.getParameter("rtype");
        SNUM = request.getParameter("rnum");
        SADD = request.getParameter("radd");
        STIME = request.getParameter("rtime");
        pw.println("<body style=\"background-color: #0E0B0B;\">");
        pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">FETCH AND FLEX</h1>");

        try { 
       
            SQLConnection obj = new SQLConnection();
            OracleConnection conn;
            conn = obj.connect();
            obj.createDoctors();
            ops = (OraclePreparedStatement) conn.prepareStatement("INSERT INTO create_doctors (NAME, TYPE, PHONE_NUMBER, ADDRESS, TIME) VALUES (?, ?, ?, ?, TO_TIMESTAMP(?, 'HH:MI AM'))");

            ops.setString(1, SNAME);
            ops.setString(2, STYPE);
            ops.setString(3, SNUM);
            ops.setString(4, SADD);
            ops.setString(5, STIME);
            

            int rowsInserted = ops.executeUpdate();
            if (rowsInserted > 0) {
                pw.println("<h1 style=\"color: white;text-align: center;font-size: 30px;\">Doctor/Trainer Details added!</h1>");            } else {
                pw.println("<h3>Failed to add request.</h3>");
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