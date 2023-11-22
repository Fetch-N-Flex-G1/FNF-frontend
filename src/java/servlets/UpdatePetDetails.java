/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import helperclasses.SQLConnection;
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
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author ujucoco
 */
public class UpdatePetDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    OraclePreparedStatement ops;
    ResultSet rs;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            
            
            HttpSession session = request.getSession();
            String userEmail = (String) session.getAttribute("OWNER_EMAIL");
            String default_pet_name = (String)session.getAttribute("PET_NAME");
            String default_owner_name= (String)session.getAttribute("OWNER_NAME");
            String default_weight = (String)session.getAttribute("WEIGHT");
            String default_height = (String)session.getAttribute("HEIGHT");
            String default_breed = (String)session.getAttribute("BREED");
            String default_age = (String)session.getAttribute("AGE");
            String default_gender = (String)session.getAttribute("PET_GENDER");
            
            System.out.println("Email : " + userEmail);
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>Register</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<h1>Servlet Register</h1>");
            
            String P_NAME = request.getParameter("Pet_Name")!= ""?request.getParameter("f_name"):default_pet_name;
            String O_NAME = request.getParameter("Owner_Name")!= ""?request.getParameter("l_name"):default_owner_name;
            String P_WEIGHT = request.getParameter("Weight")!= ""?request.getParameter("ph_no"):default_weight;
            String P_HEIGHT = request.getParameter("Height")!= ""?request.getParameter("ph_no"):default_height;
            String P_BREED = request.getParameter("Breed")!= ""?request.getParameter("ph_no"):default_breed;
            String P_AGE= request.getParameter("Age")!= ""?request.getParameter("address"):default_age;
            String P_GENDER = request.getParameter("Gender")!= ""?request.getParameter("ph_no"):default_gender;
            System.out.println( default_gender);
            
            String SEMAIL= userEmail;
//            System.out.println(SF_NAME+SPH_NO+SADDRESS+SGENDER+SEMAIL);
            pw.println("<body style=\"background-color: #0E0B0B;\">");
            pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">Fetch and Flex</h1>");
            
            
            
            SQLConnection obj = new SQLConnection();
            OracleConnection conn;
            conn = obj.connect();
            ops = (OraclePreparedStatement) conn.prepareStatement("UPDATE pet_details set pet_name = ?,owner_name = ?,weight = ?,height = ?,breed = ?,age = ?,pet_gender = ? where owner_email = ?");
            ops.setString(1,P_NAME );
            ops.setString(2,O_NAME );
            ops.setString(3, P_WEIGHT);
            ops.setString(4, P_HEIGHT);
            ops.setString(5, P_BREED);
            ops.setString(6,P_AGE);
            ops.setString(7,P_GENDER);
            ops.setString(8,userEmail);
 
            System.out.println(SEMAIL);
            int rowsUpdated = ops.executeUpdate();
            if (rowsUpdated > 0) {
//                conn.commit();
                pw.println("<h1 style=\"color: white;text-align: center;font-size: 30px;\">Your pet's details have been updated</h1>");
                
                pw.println("<p style=\"color: white; text-align: center; font-size: 16px;\">You can proceed back to the home screen</p>");
                pw.println("<div style=\"text-align: center;\">");
                pw.println("<button style=\"padding: 10px 35px; border-radius: 40px; background-color: #ee6010; color: white; border-color: transparent; font-size: 15px; font-weight: 650;\" onclick=\"window.location.href='./../../Fetch-N-Flex/JSPs/home.jsp'\">Return to Home</button>");
                pw.println("</div>");
            }
            else {
                pw.println("<h3>Failed to update pet details.</h3>");
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateUserDetails.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
