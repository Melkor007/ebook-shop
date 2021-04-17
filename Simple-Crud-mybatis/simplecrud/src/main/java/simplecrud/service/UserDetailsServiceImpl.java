package simplecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private HashMap<String,User> roles = new HashMap<>();

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        List<simplecrud.domain.User> userList = userService.userList();
        int size = userList.size();
        for(int i=0;i<size;i++){
            String username = userList.get(i).getUser_name();
            String password = userList.get(i).getUser_password();
            int roleNum = userList.get(i).getUser_role();
            String role="";
            if(roleNum==0){
                role = "ROLE_ADMIN";
            }
            else{
                role = "ROLE_USER";
            }
            roles.put(username,new User(
                    username,passwordEncoder.encode(password),getAuthority(role)
            ));
        }
        roles.put("admin", new User(
                "admin",
                passwordEncoder.encode("admin"),
                getAuthority("ROLE_ADMIN")));
        roles.put("user", new User(
                "user",
                passwordEncoder.encode("user"),
                getAuthority("ROLE_USER")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return roles.get(username);
    }

    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}


