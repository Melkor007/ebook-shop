package edu.bjtu.sei.simplecrud.controller.dto;

import edu.bjtu.sei.simplecrud.domain.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserRegistrationDto {

    @NotEmpty
    private String user_name;

    @NotEmpty
    private String user_password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String user_phone_num;

    @NotEmpty
    private String user_id_num;

    @NotEmpty
    private Role role;
}
