package services;

import sun.plugin2.message.Message;
import sun.plugin2.message.transport.Transport;

import java.util.Properties;

public class Mail {

    public String sendMail(String mailDestino, String Asunto, String Mensaje) {
        String response = null;
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

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDestino));

            message.setSubject(Asunto);

            message.setText(Mensaje);

            Transport t = session.getTransport("smtp");

            t.connect("soporte.demo489@gmail.com", "your_gmail_password");
            t.sendMessage(message, message.getAllRecipients());

            t.close();
            response = "El correo electrónico fue enviado correctamente.";

            return response;

        } catch (Exception e) {
            System.out.println("Error Mail.sendMail: " + e.getMessage());
            response = e.getMessage();
            return response;
        }
    }

}
