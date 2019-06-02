/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
/**
 *
 * @author el3ctrix
 */
@ManagedBean(name="envCorreo")
public class EmailSender {
    private String from = "elcartografoadm1@gmail.com";
    private String password = "elcartografo1";
    
    public void enviaCorreo(String to) throws MessagingException{
        Session session = creaSesion();
        MimeMessage message = new MimeMessage(session);
        preparaMensaje(message,to);
        Transport.send(message);
    }
    
    public Session creaSesion(){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        Session session = Session.getInstance(prop, new Authenticator(){
        @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        return session;
    }
    
    public void preparaMensaje(MimeMessage message, String to) throws MessagingException{
        message.setFrom(new InternetAddress(from));
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Mensaje de Prueba");
        message.setText("Esto es una prueba alv, esto es sad");
    }
}
