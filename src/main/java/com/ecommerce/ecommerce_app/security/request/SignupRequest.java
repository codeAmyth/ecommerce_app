package com.ecommerce.ecommerce_app.security.request;

import com.ecommerce.ecommerce_app.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 7, max = 50)
    @Email
    private String email;
    private Set<String> roles;
    @NotBlank
    @Size(min = 8, max = 15)
    private String password;
}
