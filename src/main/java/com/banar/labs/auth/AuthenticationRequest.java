package com.banar.labs.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
@Data
public class AuthenticationRequest {

    //    @Email(message = "Email is not well formatted")
//    @NotEmpty(message = "Email is mandatory")
//    @NotNull(message = "Email is mandatory")
    private String email;


    private String password;;
}
