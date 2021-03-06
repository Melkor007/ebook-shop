package simplecrud.controller.dto;

import simplecrud.domain.Role;
import lombok.Getter;
import lombok.Setter;

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
    private int user_id;

    @NotEmpty
    private Role role;
}
