
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
import javax.servlet.http.HttpSession;

public class PetDetails extends HttpServlet {

    // STEP 1: DECLARING ORACLE OBJECTS
  
    OraclePreparedStatement ops;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("username");

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Register</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Servlet Register</h1>");
        String P_NAME = request.getParameter("Pet_Name");
        String O_NAME = request.getParameter("Owner_Name");
        String PWEIGHT = request.getParameter("Weight");
        String PHEIGHT = request.getParameter("Height");
        String PBREED = request.getParameter("Breed");
        String PAGE = request.getParameter("Age");
        String PGENDER = request.getParameter("gender");
        String PDATE = request.getParameter("date");
        String PEMAIL = userEmail;
        pw.println("<body style=\"background-color: #0E0B0B;\">");
        pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">Fetch and Flex</h1>");
        
        

        try { 
            SQLConnection obj = new SQLConnection();
            OracleConnection conn;
            conn = obj.connect();
            obj.createPetDetails();
            ops = (OraclePreparedStatement) conn.prepareStatement("INSERT INTO pet_details(Pet_Name,Owner_Name,Weight,Height,Breed,Age,Pet_gender,DateOfBirth,owner_email) values(?,?,?,?,?,?,?, TO_DATE(?, 'YYYY-MM-DD'),?)");
            ops.setString(1,P_NAME);
            ops.setString(2,O_NAME);
            ops.setString(3,PWEIGHT);
            ops.setString(4,PHEIGHT);
            ops.setString(5,PBREED);
            ops.setString(6,PAGE);
            ops.setString(7,PGENDER);
            ops.setString(8,PDATE);
            ops.setString(9,PEMAIL);
            System.out.println(PEMAIL);
            int rowsInserted = ops.executeUpdate();
            if (rowsInserted > 0) {
                pw.println("<h1 style=\"color: white;text-align: center;font-size: 40px;font-family:DM Sans;\">Details added successfully</h1>");
                pw.println("<p style=\"color: white; text-align: center; font-size: 16px;\">Please Log In To Continue</p>");
                pw.println("<div style=\"text-align: center;\">");
                pw.println("<button style=\"padding: 10px 35px; border-radius: 40px; background-color: #ee6010; color: white; border-color: transparent; font-size: 15px; font-weight: 650;\" onclick=\"window.location.href='./../../Fetch-N-Flex/Pages/login.html'\">Login</button>");
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


