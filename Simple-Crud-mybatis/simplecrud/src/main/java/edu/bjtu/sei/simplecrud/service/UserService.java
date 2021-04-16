package edu.bjtu.sei.simplecrud.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.bjtu.sei.simplecrud.domain.User;
import edu.bjtu.sei.simplecrud.controller.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

//public interface UserService extends UserDetailsService {
@Service
public interface UserService {
    User findById(int user_id_num);

    User save(UserRegistrationDto registration);

    void delete(int user_id);
}
