package com.example.sbemailverification.services;

import com.example.sbemailverification.dto.request.RegistrationRequest;
import com.example.sbemailverification.registration.token.VerificationToken;
import com.example.sbemailverification.user.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getUsers();

    User registerUser(RegistrationRequest request);

    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theUser, String verificationToken);

    String validateToken(String theToken);
}
