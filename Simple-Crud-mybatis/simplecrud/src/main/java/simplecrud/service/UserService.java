package simplecrud.service;

import simplecrud.domain.Book;
import simplecrud.domain.User;
import simplecrud.controller.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.List;

//public interface UserService extends UserDetailsService {
@Service
public interface UserService {

    List<User> userList();

    User findById(int user_id_num);

    User save(UserRegistrationDto registration);

    void delete(int user_id);

    boolean login(String username, String user_password);
}
