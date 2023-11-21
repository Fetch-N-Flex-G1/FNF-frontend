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
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleResultSetMetaData;

public class Login extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_creds WHERE EMAIL=? AND PASSWORD=?";
    static OracleConnection oconn;
    
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
            oconn = null;
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
                
                if (resultSet.next()) {
                    // Store username in session
                    HttpSession session = request.getSession();
                    session.setAttribute("username", userEmail);
                    System.out.println(session);
                    System.out.printf("\u001B[34m%s\u001B[0m", userEmail);
                    
                    
                 
                    setUserSessionInfo(userEmail,request,response);
                    setUserPetInfo(userEmail,request,response);
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
        
    
        void setUserSessionInfo(String user_email, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
            OraclePreparedStatement ops;
            OracleResultSet ors = null;
            OracleResultSetMetaData orsmd = null;
            
            HttpSession user_details = request.getSession(); 
//            if(user_details.getAttribute("EMAIL")==null){
                System.out.println(user_details.getAttribute("EMAIL")==null);
                // Execute SQL query
                String query = "SELECT * FROM user_details WHERE EMAIL = ?";
                ops = (OraclePreparedStatement) oconn.prepareStatement(query);
                ops.setString(1, user_email);
    //            try{


                // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
                try{
                    ors = (OracleResultSet) ops.executeQuery();
                    orsmd = (OracleResultSetMetaData) ors.getMetaData();
                }
                catch(java.sql.SQLSyntaxErrorException ex){
    //                 dataNotFound("user", response);
//                    response.sendRedirect("../../../Fetch-N-Flex/Pages/user_details.html");
                }
                if (ors.next()) {
                            for (int counter = 1; counter < orsmd.getColumnCount(); counter++) {
                                            String column_name = orsmd.getColumnName(counter);
                                            String column_value = ors.getString(counter);
                                            user_details.setAttribute(column_name, column_value);

                            }
                }
                else{
//                   dataNotFound("user", response);
    //                response.sendRedirect("../../../Fetch-N-Flex/Pages/user_details.html");
                   System.out.println("User data not found");
                }
//            }
//            setUserPetInfo(user_email,request,response);
            
        
    } 
    void setUserPetInfo(String user_email, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
            OraclePreparedStatement ops;
            OracleResultSet ors = null;
            OracleResultSetMetaData orsmd = null;
            
            HttpSession user_details = request.getSession(); 
//            if(user_details.getAttribute("OWNER_EMAIL")==null){
                System.out.println(user_details.getAttribute("OWNER_EMAIL")==null);
            // Execute SQL query
                String query = "SELECT * FROM pet_details WHERE OWNER_EMAIL = ?";
                ops = (OraclePreparedStatement) oconn.prepareStatement(query);
                ops.setString(1, user_email);


                // STEP 8: GETTING THE COLUMNS INFORMATION(METADATA)
                try{
                    ors = (OracleResultSet) ops.executeQuery();
                    orsmd = (OracleResultSetMetaData) ors.getMetaData();
                }
                catch(java.sql.SQLSyntaxErrorException ex){
//                     dataNotFound("pet", response);
    //                response.sendRedirect("../../../Fetch-N-Flex/Pages/PetDetails.html");
                }
                if (ors.next()) {
                            for (int counter = 1; counter < orsmd.getColumnCount(); counter++) {
                                            String column_name = orsmd.getColumnName(counter);
                                            String column_value = ors.getString(counter);
                                            user_details.setAttribute(column_name, column_value);

                            }
                }
                else{
//                    dataNotFound("pet", response); 
    //                response.sendRedirect("../../../Fetch-N-Flex/Pages/PetDetails.html");
                    System.out.println("pet data not found");
                }
    }
            
                
//                response.sendRedirect("../../../Fetch-N-Flex/JSPs/home.jsp");
            
 }        
        
    
//    void dataNotFound(String name, HttpServletResponse response) throws IOException{
//        PrintWriter pw = response.getWriter();
//        System.out.println("Redirecting to"+name+" details");
//        System.out.println(pw);
//        String url = ("user".equals(name)) ? "user_details" : "PetDetails";
//        System.out.println(url);
//        pw.println("<body style=\"background-color: #0E0B0B;\">");
//        pw.println("<h1 style=\"color: #d0540e;text-align: center;font-size: 40px;\">Fetch and Flex</h1>");
//        pw.println("<h1>Please add your" +name+ "details to proceed</h1>");
//        pw.println("<div style=\"text-align: center;\">");
//        pw.println("<button style=\"padding: 10px 35px; border-radius: 40px; background-color: #ee6010; color: white; border-color: transparent; font-size: 15px; font-weight: 650;\" onclick=\"window.location.href='./../../Fetch-N-Flex/Pages/"+url+".html'\">add " +name+" details</button>");
//        pw.println("</div>");
//        pw.println("</body>");
//        
//    }
//}
