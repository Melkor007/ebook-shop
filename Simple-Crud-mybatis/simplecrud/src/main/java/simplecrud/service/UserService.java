package simplecrud.service;

import simplecrud.domain.Book;
import simplecrud.domain.Role;
import simplecrud.domain.User;
import simplecrud.controller.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.List;

//public interface UserService extends UserDetailsService {
@Service
public interface UserService {

    List<User> userList();

    User findById(int user_id_num);

    User findByName(String username);

    User save(UserRegistrationDto registration);

    void delete(int user_id);

    boolean login(String username, String user_password);

    Role checkRole(String user_name);

    void deleteuser(int user_id);
}
