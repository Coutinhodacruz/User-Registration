package com.example.sbemailverification.registration;


import com.example.sbemailverification.dto.request.RegistrationRequest;
import com.example.sbemailverification.event.RegistrationCompleteEvent;
import com.example.sbemailverification.registration.token.VerificationToken;
import com.example.sbemailverification.repositories.VerificationTokenRepository;
import com.example.sbemailverification.services.UserServices;
import com.example.sbemailverification.user.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {


    private final UserServices userServices;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;


    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user = userServices.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));

        return "Success! please check your email to complete your registration";
    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        VerificationToken theToken = tokenRepository.findByToken(token);
        if (theToken.getUser().isEnabled()){
            return "This account has already been verify";
        }
        String verificationResult = userServices.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return "Email verify successfully. Now you can login to your account";
        }else {
            return "Invalid verification token";
        }

    }






    public String applicationUrl(HttpServletRequest request) {

        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
