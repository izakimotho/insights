
package com.lunna.insight.Core.mailer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class SendMail {

    public static void send(final String host, final String port, final String authReq, final String accountName, final String source, final String sourcePassword, final String destination, final String content, final String subject, final String messageType) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /*Properties props = new Properties();
                    props.put("mail.host", host);
                    props.put("mail.port", port);
                    props.put("mail.smtp.auth", authReq);
                    props.put("mail.smtp.starttls.enable", authReq);
                    props.put("mail.debug", "true");
                    props.put("mail.smtp.socketFactory.fallback", "true");
                    Session mailConnection = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(source, sourcePassword);
                            }
                        });

                    Message msg = new MimeMessage(mailConnection);

                    Address from = new InternetAddress(source, accountName);
                    InternetAddress[] iAddressArray = InternetAddress.parse(destination);
                    msg.setContent(content, messageType);

                    msg.setFrom(from);
                    msg.setRecipients(Message.RecipientType.TO, iAddressArray);
                    msg.setSubject(subject);

                    //Transport.send(msg);
                    Transport transport = mailConnection.getTransport("smtps");
                    transport.connect(host, Integer.parseInt(port), source, sourcePassword);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();*/

                    Properties properties = new Properties();
                    properties.put("mail.smtp.host", host);
                    properties.put("mail.smtps.auth", authReq);
                    properties.put("mail.smtp.port", port);
                    //properties.put("mail.smtp.ssl.enable", authReq);
                    properties.put("mail.smtp.starttls.enable", authReq);
                    properties.put("mail.debug", "true");

                    Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(source, sourcePassword);
                        }
                    });
                    session.setDebug(true);
                    Message msg = new MimeMessage(session);

                    InternetAddress fromAddress;
                    fromAddress = new InternetAddress(source, accountName);
                    msg.setFrom(fromAddress);

                    InternetAddress[] iAddressArray = InternetAddress.parse(destination);

                    msg.setRecipients(Message.RecipientType.TO, iAddressArray);

                    //set the subject and content type
                    msg.setSubject(subject);
                    msg.setContent(content, messageType);

                    Transport.send(msg, msg.getAllRecipients());
                    /*//send the email
                    Transport transport = session.getTransport("smtps");
                    transport.connect(host, Integer.parseInt(port), source, sourcePassword);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();*/

                    //System.out.println("Sent email to: " + destination);
                } catch (MessagingException | UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
