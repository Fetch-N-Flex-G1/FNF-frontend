
package servlets;


public class User {
    String name;
    String email;
    String code;
    
    
    public User(){
    }
    
    public User(String name, String email, String code) {
        
   
        this.email = email;
        this.code = code;
    }

    User(String email, String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    
}