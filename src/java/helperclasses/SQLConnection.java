/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperclasses;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleConnection;
/**
 *
 * @author ujucoco
 */
public class SQLConnection {
    public static OracleConnection oconn;
    
    public OracleConnection connect() throws SQLException{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            oconn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "c##fandf", "database");
            return oconn;
           
    }
    
    public void runQuery(String query) throws SQLException{
            Statement statement = oconn.createStatement();
            statement.execute(query);
            
    }
    public void createUserCreds() throws SQLException{
        runQuery("create table if not exists user_creds(email varchar2(255), password varchar2(255))");
    }
    public void createContacts() throws SQLException{
        runQuery("create table if not exists contacts( NAME varchar2(100), PHONE_NUMBER number(20), EMAIL varchar2(100));");
    }
    public void quit() throws SQLException{
        oconn.close();
    }
}