package com.example.sbemailverification.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.example.sbemailverification.dto.request.RegistrationRequest;
import com.example.sbemailverification.exception.UserAlreadyExistsException;
import com.example.sbemailverification.repositories.UserRepository;
import com.example.sbemailverification.user.User;
import org.junit.jupiter.api.Test;


import org.springframework.security.crypto.password.PasswordEncoder;



public class UserServicesTest {

//    private final UserRepository userRepository = mock(UserRepository.class);
//    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
//
//    private final UserServices userService = new UserServices(userRepository, passwordEncoder);


    @Test
    public void testRegisterUser_Success() {
//        RegistrationRequest request = new RegistrationRequest("John", "Doe", "john@example.com", "password", "ROLE_USER");
//
//        // Configure userRepository mock to return an empty Optional when findByEmail is called
//        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
//
//        // Configure passwordEncoder mock to return the same password for encoding
//        when(passwordEncoder.encode(anyString())).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Register the user
//        User newUser = userService.registerUser(request);
//
//        // Check if the user is registered correctly
//        assertNotNull(newUser.getId());
//        assertEquals("John", newUser.getFirstName());
//        assertEquals("Doe", newUser.getLastName());
//        assertEquals("john@example.com", newUser.getEmail());
//        assertEquals("ROLE_USER", newUser.getRole());
//
//        // Verify interactions with mocks
//        verify(userRepository, times(1)).findByEmail("john@example.com");
//        verify(passwordEncoder, times(1)).encode("password");
//        verify(userRepository, times(1)).save(newUser);
//        verifyNoMoreInteractions(userRepository, passwordEncoder);
//    }
//
//    @Test
//    public void testRegisterUser_UserAlreadyExists() {
//        RegistrationRequest request = new RegistrationRequest("John", "Doe", "john@example.com", "password", "ROLE_USER");
//
//        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(new User()));
//
//        try {
//            userService.registerUser(request);
//            fail("Expected UserAlreadyExistsException");
//        } catch (UserAlreadyExistsException e) {
//            // Expected exception
//        }
//
//        verify(userRepository, times(1)).findByEmail("john@example.com");
//        verifyNoMoreInteractions(passwordEncoder, userRepository);
//    }
    }
}
