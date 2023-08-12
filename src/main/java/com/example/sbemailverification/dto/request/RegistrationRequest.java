package com.example.sbemailverification.dto.request;



public record RegistrationRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String password,
                                  String role

                                  ) {

}
