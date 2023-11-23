/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import helperclasses.SQLConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author ujucoco
 */
public class DeleteUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static OracleConnection oconn;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUser at " + request.getContextPath() + "</h1>");
            
            
            String user_name = (String) session.getAttribute("EMAIL");
            int results = 0;
            
            try {
                SQLConnection sqlcn = new SQLConnection();
                if (sqlcn.exists("SUBSCRIBERS"))
                    results = results + deleteValue("subscribers","email",user_name);
                if(sqlcn.exists("USER_DETAILS"))
                    results = results + deleteValue("user_details","email",user_name);
                if(sqlcn.exists("PET_DETAILS"))
                    results = results + deleteValue("pet_details","owner_email",user_name);
                if(sqlcn.exists("USER_CREDS"))
                    results = results + deleteValue("user_creds","email",user_name) + 5;

            } catch (SQLException ex) {
                Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            session.invalidate();
            System.out.print("Total result : " + results);
            if(results>5){
                out.println("<h1 style=\"background-color: #000000; color: #d9570f; text-align: center;\">All user data deleted</h1>");
                out.println("<a href = '../../../Fetch-N-Flex/web/index.html'><p>ok</p></a>");
            }
            else{
                out.println("<h1>Failed to delete user data</h1>");
                out.println("<a href = 'javascript:history.back()'><p>go back</p></a>");
            }
            out.println("</body>");
            out.println("</html>");
            
            
  
    }
    int deleteValue(String table_name, String field, String user_name){
        System.out.println(user_name);
        System.out.println("Deleting "+table_name);
        SQLConnection sqlcon = new SQLConnection();
        try {
            oconn = sqlcon.connect();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            OraclePreparedStatement ops = (OraclePreparedStatement) oconn.prepareStatement("Delete from "+table_name+" where "+field+" = ?");
            System.out.println("Inside try");
            ops.setString(1, user_name);
            int r = ops.executeUpdate();
            System.out.println(r);
            return r;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
