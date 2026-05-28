//package model;
//
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class EmailSender {
//
//    public static void sendVerificationCode(String recipientEmail) {
//        final String username = "your-email@gmail.com";
//        final String password = "your-email-password";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            message.setSubject("Two-Factor Authentication Code");
//            int verificationCode = generateVerificationCode();
//            message.setText("Your verification code is: " + verificationCode);
//
//            Transport.send(message);
//
//            System.out.println("Verification code sent successfully.");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static int generateVerificationCode() {
//        return (int) ((Math.random() * 900000) + 100000);
//    }
//
//    public static void main(String[] args) {
//        sendVerificationCode("123456arashsaeed@gamil.com");
//    }
//}