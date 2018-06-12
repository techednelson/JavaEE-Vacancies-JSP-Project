package services;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {

    public String sendMail(String mailDestiny, String subject, String msg) {
        String response;
        try {

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");

            props.setProperty("mail.smtp.user", "soporte.demo489@gmail.com");
            props.setProperty("mail.smtp.auth", "true");


            Session session = Session.getDefaultInstance(props);


            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("soporte.demo489@gmail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDestiny));

            message.setSubject(subject);

            message.setText(String.valueOf(message));

            Transport t = session.getTransport("smtp");

            t.connect("soporte.demo489@gmail.com", "your_gmail_password");
            t.sendMessage(message, message.getAllRecipients());

            t.close();
            response = "E-mail was sent correctly.";

            return response;

        } catch (Exception e) {
            System.out.println("Error Mail.sendMail: " + e.getMessage());
            response = e.getMessage();
            return response;
        }
    }

}
