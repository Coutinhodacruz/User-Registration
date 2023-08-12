package com.example.sbemailverification.listener;

import com.example.sbemailverification.event.RegistrationCompleteEvent;
import com.example.sbemailverification.services.UserServices;
import com.example.sbemailverification.user.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserServices userServices;

    private final JavaMailSender mailSender;

    private  User theUser;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Get the newly register User
         theUser = event.getUser();
        // Create a verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        // Save the verification token for the user
        userServices.saveUserVerificationToken(theUser, verificationToken);

        // Build the verification Url to be sent to the user
        String url = event.getApplicationUrl()+"/register/verifyEmail"+verificationToken;
        // Send the email
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {

            throw new RuntimeException(e);
        }
        log.info("Click the link to verify your account -->{}", url);

    }

    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email verification";
        String senderName = "User Registration Portal service";
        String mailContent = "<p> Hi "+ theUser.getFirstName()+ ", </p>"+
                "<p>Thank you for registering with us,"+" "+
                "Please, follow the link below to complete your registration.</p>"+
                "<a href=\""+url+"\">Verify your email to activate your account </a>"+
                "<p> Thank you <br> Users Registration Portal Service";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("coutinhodacruz@gmal.com", senderName);
        messageHelper.setTo(theUser.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
}
