package edu.bjtu.sei.simplecrud.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bjtu.sei.simplecrud.domain.Role;
import edu.bjtu.sei.simplecrud.domain.User;
import edu.bjtu.sei.simplecrud.mapper.UserMapper;
import edu.bjtu.sei.simplecrud.controller.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findById(String user_id_num){
        return userRepository.findById(user_id_num);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();

        user.setUser_name(registration.getUser_name());
        user.setUser_password(passwordEncoder.encode(registration.getUser_password()));
        user.setUser_phone_num(registration.getUser_phone_num());
        user.setUser_id_num(registration.getUser_id_num());

        userRepository.save(user);
        return user;
    }

    public void delete(String user_id_num){
        userRepository.delete(user_id_num);
    }

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        User user = userRepository.findByName(user_name);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUser_id_num(),
                user.getUser_password(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}