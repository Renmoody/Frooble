package com.example.frooble;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import android.content.Intent;
import android.net.Uri;
import android.content.Context;


public class Email extends Authenticator {

    private String email;
    private String message;
    private Context context;

    public Email(Contact contact, String message, Context context) {
        this.email = contact.getEmail();
        if (message == null) {
            this.message = "There was no specific message";
        } else {
            this.message = message;
        }

    }

    public void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + this.email));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "URGENT");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        // Check if there's an email client installed on the device
        if (emailIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(Intent.createChooser(emailIntent, "Send Email"));
        }
    }
//    public void send() {
//        String mEmail = email.getText().toString();
//        String mSubject = subject.getText().toString();
//        String mMessage = message.getText().toString();
//
//
//        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);
//
//        javaMailAPI.execute();
//    }

//    public void send() {
//        String host = "smtp.gmail.com";
//        String port = "587";
//        String username = "fubleproject@gmail.com";
//        String password = "FubleProjectEmail";
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//
//        // Import Session from javax.mail package and use it
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication(username, password);
//            }
//        });
//        try {
//            // Create a default MimeMessage object
//            Message mimeMessage = new MimeMessage(session);
//
//            // Set From: header field of the header
//            mimeMessage.setFrom(new InternetAddress(username));
//
//            // Set To: header field of the header
//            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//
//            // Set Subject: header field
//            mimeMessage.setSubject("Fruble Detected an Emergency!");
//
//            // Now set the actual message
//            mimeMessage.setText(message);
//
//            // Send message
//            Transport.send(mimeMessage);
//
//            System.out.println("Email sent successfully");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
