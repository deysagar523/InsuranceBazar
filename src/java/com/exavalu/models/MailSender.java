/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 * The model has all the instance variables declared .Also logics for mail
 * integration are written
 *
 * @author ASUS
 */
public class MailSender {

    static String fromEmail = "deysagar523@gmail.com";
    static String password = "bnmsmzdhilbnajxs";
    static String userName = "deysagar523";
    static String message = "successfully signed up ";

    public static void sendEmailToRegisterUser(String toEmail) {
        try {
            System.out.println(toEmail);
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Successfully Account Created");
            mailMessage.setText("You are Successfully signed up to Insurance Bazar , now login and buy some policies you like");

            Transport.send(mailMessage);

        } catch (AddressException ex) {
            System.out.println("In the catch");
            System.out.println(ex.getMessage());
        } catch (MessagingException ex) {
            System.out.println("In the catch");
            System.out.println(ex.getMessage());
        }
    }

    public static void sendEmailAfterBikePayment(String bikeMake, String bikeModel, String bikeNumber, String toEmail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Successfully Payment Done of " + bikeNumber + " in InsueranceBazar");
            String bikeMakeFullName = null;
            if (bikeMake.equalsIgnoreCase("HO")) {
                bikeMakeFullName = "Honda";
            } else if (bikeMake.equalsIgnoreCase("YA")) {
                bikeMakeFullName = "Yamaha";
            } else if (bikeMake.equalsIgnoreCase("RE")) {
                bikeMakeFullName = "Yamaha";
            } else if (bikeMake.equalsIgnoreCase("BA")) {
                bikeMakeFullName = "Bajaj";
            } else if (bikeMake.equalsIgnoreCase("SU")) {
                bikeMakeFullName = "Suzuki";
            } else if (bikeMake.equalsIgnoreCase("HD")) {
                bikeMakeFullName = "Harley Davidson";
            } else if (bikeMake.equalsIgnoreCase("HM")) {
                bikeMakeFullName = "Hero Motocarp";
            } else if (bikeMake.equalsIgnoreCase("MA")) {
                bikeMakeFullName = "Mahindra";
            }

            mailMessage.setText("Relax, now your bike " + bikeMakeFullName + " " + bikeModel + " " + " is safe with us!!!");
            Transport.send(mailMessage);

        } catch (AddressException ex) {

        } catch (MessagingException ex) {

        }
    }

    static void sendEmailAfterChildPayment(String childName, String childBirthNo, String childAge, String toEmail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Successfully Payment Done for your child " + childName + " in InsueranceBazar");

            mailMessage.setText("Relax, now your child " + childName + " with birth certificate Number" + childBirthNo + "is safe with us");

            Transport.send(mailMessage);

        } catch (AddressException ex) {

        } catch (MessagingException ex) {

        }
    }

    static void sendEmailAfterMediclaimPayment(String adharCard, String relation, String relativeName, String disease, String toEmail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Successfully Payment Done of adhar card no" + adharCard + " in InsueranceBazar");

            System.out.println("relative name " + relativeName);
            if (relativeName.length() == 0) {
                mailMessage.setText("You Issue this mediclaim for Self");
            } else {
                mailMessage.setText("You Issue this mediclaim for " + relation + " whose name is " + relativeName);
            }

            Transport.send(mailMessage);

        } catch (AddressException ex) {

        } catch (MessagingException ex) {

        }
    }

    static void sendEmailAfterRejectPolicy(String policyName, String toEmail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Rejection Of Policy By Underwriter");

            mailMessage.setText("Your policy " + policyName + " is rejected due to mismatch fields");

            Transport.send(mailMessage);

        } catch (AddressException ex) {

        } catch (MessagingException ex) {

        }
    }

    static void sendEmailAfterIssuePolicy(String policyName, String toEmail) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message mailMessage = new MimeMessage(session);

            //setting up all the messages
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            mailMessage.setSubject("Issue Of Policy By Insurance Officer");

            mailMessage.setText("Your policy " + policyName + " is isseued by Insurance Officer");

            Transport.send(mailMessage);

        } catch (AddressException ex) {

        } catch (MessagingException ex) {

        }
    }
}
