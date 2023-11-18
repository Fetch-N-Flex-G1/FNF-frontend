/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperclasses;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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
            oconn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:free", "c##fandf", "database");
            return oconn;
    }
    
    public void runQuery(String table_name, String query) throws SQLException{
            Statement statement = oconn.createStatement();
            DatabaseMetaData metaData = oconn.getMetaData();
            ResultSet tables = metaData.getTables(null, null, table_name, null);

            if (tables.next()) {
                System.out.println("Table " + table_name + " exists.");
            } else {
                System.out.println("Table " + table_name + " does not exist.");
                statement.execute(query);
            }
    }
    public void createUserCreds() throws SQLException{
        runQuery("user_creds","create table user_creds(email varchar2(255) PRIMARY KEY, password varchar2(255))");
    }

    public void createContacts() throws SQLException{
        runQuery("contacts","create table contacts(NAME varchar2(100), PHONE_NUMBER number(20), EMAIL varchar2(100))");
    }
    
    public void createUserDetails() throws SQLException{
        runQuery("user_details","create table user_details(f_name varchar2(100), l_name varchar2(100), email varchar2(255), ph_no number(20),address varchar2(400), gender varchar2(30),FOREIGN KEY (email) REFERENCES user_creds(email))");
    }
    public void createPetDetails() throws SQLException{
        runQuery("pet_details","create table pet_details(Pet_Name varchar2(100), Owner_Name varchar2(100), Weight number(20), Height number(20),Breed varchar2(400), Age number(30),Gender varchar2(30))");
    }
    
    public void createFeedback() throws SQLException{
        runQuery("feedback","create table feedback(NAME varchar2(200), EMAIL varchar2(200), FEEDBACK varchar2(1000))");
    }

    public void createGetInTouch() throws SQLException{
        runQuery("get_in_touch","create table get_in_touch(NAME varchar2(200), EMAIL varchar2(200), MESSAGE varchar2(1000))");
    }

    public void quit() throws SQLException{
        oconn.close();
    }
}
