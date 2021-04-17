package simplecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplecrud.domain.Role;
import simplecrud.domain.User;
import simplecrud.mapper.UserMapper;
import simplecrud.controller.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userRepository;

    public User findById(int user_id){
        return userRepository.findById(user_id);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();

        user.setUser_name(registration.getUser_name());
        user.setUser_id(registration.getUser_id());

        //userRepository.save(user);
        return user;
    }

    public void delete(int user_id){
        userRepository.delete(user_id);
    }

    @Override
    public boolean login(String username, String user_password) {
        User u = userRepository.findByName(username);
        return user_password.equals(u.getUser_password());
    }

    @Override
    public void deleteuser(int user_id) {
        userRepository.deleteUser(user_id);
    }


    public List<User> userList(){
        return userRepository.userList();
    };

}
