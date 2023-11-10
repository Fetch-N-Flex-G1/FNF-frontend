package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class signup extends HttpServlet {
    String SEMAIL, SPASS;

    // STEP 1: DECLARING ORACLE OBJECTS
    OracleConnection oconn;
    OraclePreparedStatement ops;
    ResultSet rs;

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
        pw.println("<h1>Printing the HTML Form values in this servlet....</h1>");

        try {
            // STEP 2: REGISTERING THE ORACLE DRIVER WITH THIS SERVLET
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            // STEP 3: INSTANTIATING THE ORACLE CONNECTION OBJECT
            oconn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:free", "c##coco", "uju");

            // STEP 4: INSTANTIATING THE ORACLE PREPARED STATEMENT OBJECT
            ops = (OraclePreparedStatement) oconn.prepareStatement("INSERT INTO user_credentials(EMAIL, PASSWORD) values(?, ?)");

            // STEP 6: FILLING UP THE BLANK QUERY PARAMETERS (?)
            ops.setString(1, SEMAIL);
            ops.setString(2, SPASS);

            // STEP 7: EXECUTING THE QUERY
            int rowsInserted = ops.executeUpdate();
            if (rowsInserted > 0) {
                pw.println("<h3>User registered successfully.</h3>");
            } else {
                pw.println("<h3>Failed to register user.</h3>");
            }

            // STEP 8: CLOSING THE ORACLE OBJECTS
            ops.close();
            oconn.close();

        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
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