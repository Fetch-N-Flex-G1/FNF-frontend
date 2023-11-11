/**package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helperclasses.SQLConnection;
import oracle.jdbc.OracleConnection;

public class Login extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_credentials WHERE EMAIL=? AND PASSWORD=?";

    @Override
    public void init(ServletConfig config) throws ServletException {
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

        try {
            SQLConnection scon = new SQLConnection();
            OracleConnection connection = scon.connect();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(SELECT_QUERY);


            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pw.println("<html><body>");
                pw.println("<h3>Welcome User to our site</h3>");
                RequestDispatcher rd1 = request.getRequestDispatcher("./index.html");
                rd1.include(request, response);
                pw.println("<form method=\"post\" action=\"login.html\">");
                pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
                pw.println("</form>");
                pw.println("</body></html>");

            } else {
                pw.println("<html><body>");
                pw.println("<center><h3>Invalid username/password. Enter Correct username/password</h3></center>");
                RequestDispatcher rd2 = request.getRequestDispatcher("./login.html");
                rd2.include(request, response);
                pw.println("</body></html>");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
* */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    private static final String SELECT_QUERY = "SELECT EMAIL, PASSWORD FROM user_creds WHERE EMAIL=? AND PASSWORD=?";//ekhane password tao kano fetch krchis?
    //are fetch na bolchi where e kano deachis? 
    //pass ta ke simply fetch kkre user er enter kra pass er sathe compare o toh krte paris tle bar bar db er sthe
    //connect kre query run krte hbe na tle backend e chap porbe
    //java te code likhte paris na?
    //hell even better! password ta pass kre de login.jsp ke tale okhanei red kre bole debe je bhul ache
    //nahole nije bol pass bhul hole ki kre janabi? 
    //naa page ta change joe jacche je same page e tjakte hbe je
    
    @Override
    public void init(ServletConfig config) throws ServletException {
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

        try (Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1522:free", "c##FANDf", "database");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {

            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                    // Redirect to home.html
                    response.sendRedirect("../../../Fetch-N-Flex/Pages/home.html");

                    pw.println("</body></html>");

            } else {
                pw.println("<html><body>");
                pw.println("<center><h3>Invalid username/password. Enter Correct username/password</h3></center>");
                RequestDispatcher rd2 = request.getRequestDispatcher("./login.html");
                rd2.include(request, response);
                pw.println("</body></html>");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}