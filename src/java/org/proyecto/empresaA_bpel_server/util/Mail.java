package org.proyecto.empresaA_bpel_server.util;

 
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public  class Mail {
 
    private String from="rory3333@gmail.com";
    private String to;
    private String subject;
    private String text;
    final String username="rory3333";
    final String password="ro53nd07";

    public Mail(String to, String subject, String content) {
      
        //this.from = this.from;
        this.to = to;
        this.subject = subject;
        this.text = content;
    }
 
    public void send(){
 

        Properties props = new Properties();
        
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "587");

//        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
        //   Session session = Session.getDefaultInstance(props,
          Session session = Session.getInstance(props,
                   new javax.mail.Authenticator() {
                       @Override
                    protected PasswordAuthentication  getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);}
        });
          
        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
        message.setSubject(subject);
			message.setText(text);
        Transport.send(message);
        } catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    
     public void sendSSL(){
         Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                            @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
 
			Transport.send(message);
 
			
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
         
     }
    
}

