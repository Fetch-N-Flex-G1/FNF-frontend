/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperclasses;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            ReadDBProps.loadConfig();
//            System.out.println(ReadDBProps.dbUrl+ReadDBProps.dbUser+ ReadDBProps.dbPassword);
//            oconn = (OracleConnection) DriverManager.getConnection(ReadDBProps.dbUrl, ReadDBProps.dbUser, ReadDBProps.dbPassword);
            oconn = (OracleConnection) DriverManager.getConnection(ReadDBProps.dbUrl, ReadDBProps.dbUser, ReadDBProps.dbPassword);
            return oconn;
    }
    
    public void runQuery(String table_name, String query) throws SQLException{
            Statement statement = oconn.createStatement();
            PreparedStatement stmt = oconn.prepareStatement("SELECT TABLE_NAME FROM ALL_TABLES WHERE TABLE_NAME = ?");
            stmt.setString(1, table_name);
            ResultSet tables = stmt.executeQuery();
            if (tables.next()) {
                System.out.println("Table " +table_name+ " exists");
            } else {
                System.out.println("Table " +table_name+" does not exist");
                statement.execute(query);
            }
    }
    public void createUserCreds() throws SQLException{
        runQuery("USER_CREDS","create table user_creds(email varchar2(255) PRIMARY KEY, password varchar2(255))");
    }

    public void createContacts() throws SQLException{
        runQuery("CONTACTS","create table contacts(NAME varchar2(100), PHONE_NUMBER number(20), EMAIL varchar2(100))");
    }
    
    public void createUserDetails() throws SQLException{
        runQuery("USER_DETAILS","create table user_details(f_name varchar2(100), l_name varchar2(100), email varchar2(255), ph_no number(20),address varchar2(400), gender varchar2(30),FOREIGN KEY (email) REFERENCES user_creds(email))");
    }
    public void createPetDetails() throws SQLException{
        runQuery("PET_DETAILS", "CREATE TABLE pet_details(Pet_Name varchar2(100), Owner_Name varchar2(100), Weight number(20), Height number(20), Breed varchar2(400), Age number(30), Pet_gender varchar2(30), owner_email varchar2(255), FOREIGN KEY(owner_email) REFERENCES user_creds(email))");

    }
    
    public void createFeedback() throws SQLException{
        runQuery("FEEDBACK","create table feedback(NAME varchar2(200), EMAIL varchar2(200), FEEDBACK varchar2(1000))");
    }

    public void createGetInTouch() throws SQLException{
        runQuery("GET_IN_TOUCH","create table get_in_touch(NAME varchar2(200), EMAIL varchar2(200), MESSAGE varchar2(1000))");
    }
    public void createDoctors() throws SQLException{
        runQuery("CREATE_DOCTORS", "CREATE TABLE create_doctors(NAME varchar2(200), TYPE varchar2(200), PHONE_NUMBER number(20), ADDRESS varchar2(100), TIME TIMESTAMP)");
    }
    
    public void subscribers() throws SQLException{
        runQuery("SUBSCRIBERS","create table subscribers(NAME varchar2(200), EMAIL varchar2(200), PACKAGE varchar2(200), PRICE varchar2(100))");
    }

    public void quit() throws SQLException{
        oconn.close();
    }
}
