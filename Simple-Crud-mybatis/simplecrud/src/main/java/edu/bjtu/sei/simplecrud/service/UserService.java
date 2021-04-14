package edu.bjtu.sei.simplecrud.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.bjtu.sei.simplecrud.domain.User;
import edu.bjtu.sei.simplecrud.controller.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findById(int user_id);

    User save(UserRegistrationDto registration);

    void delete(int user_id);
}
