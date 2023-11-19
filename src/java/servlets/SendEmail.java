/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Subhajit-PC
 */
public class SendEmail {
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        
        return String.format("%06d", number);
    }
    
    public boolean sendEmail(User user){
        boolean test = false;
        
        String toEmail = user.getEmail();
        String fromEmail = "fetchnflex@gmail.com";
        String password = "ewqcgsbwhyldepsi";
        
        try{
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.mail.com");
            pr.setProperty("mail.smtp.port", "507");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port","587");
            pr.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            
            
            //get session
            Session session = Session.getInstance(pr, new Authenticator(){
                
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
            Message mess = new MimeMessage(session);
            
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
           
            mess.setSubject("User Email Verification");
            mess.setText("Verify Using This Code" + user.getCode());
            
            Transport.send(mess);
            
            test = true;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        return test;
    }

    private Authenticator newAuthenticator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
