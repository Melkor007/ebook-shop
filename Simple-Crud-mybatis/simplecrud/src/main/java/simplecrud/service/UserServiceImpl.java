package simplecrud.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import simplecrud.domain.Role;
import simplecrud.domain.User;
import simplecrud.mapper.UserMapper;
import simplecrud.controller.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public User findById(int user_id){
        return userRepository.findById(user_id);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();

        user.setUser_name(registration.getUser_name());
//        user.setUser_password(passwordEncoder.encode(registration.getUser_password()));
        user.setUser_id(registration.getUser_id());

        userRepository.save(user);
        return user;
    }

    public void delete(int user_id){
        userRepository.delete(user_id);
    }

    @Override
    public boolean login(String username, String user_password) {
        User u = userRepository.findByName(username);
//        System.out.println(u.getUser_id()+u.getUser_name()+u.getUser_password());
        return user_password.equals(u.getUser_password());
    }

//    @Override
//    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
//        User user = userRepository.findByName(user_name);
//        if (user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getUser_id()),
//                user.getUser_password(),
//                mapRolesToAuthorities(user.getUser_role()));
//    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
}
