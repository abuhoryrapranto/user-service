package com.flabapp.User.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {
    
    @NotBlank(message = "First name can't be empty.")
    private String firstName;

    @NotBlank(message = "Last name can't be empty.")
    private String lastName;

    @Email
    @NotBlank(message = "Email can't be empty.")
    private String email;

    @NotBlank(message = "Phone can't be empty.")
    private String phone;

    @NotBlank(message = "Password can't be empty.")
    private String password;

    @NotBlank(message = "Confirmed password can't be empty.")
    private String confirmedPassword;
}
