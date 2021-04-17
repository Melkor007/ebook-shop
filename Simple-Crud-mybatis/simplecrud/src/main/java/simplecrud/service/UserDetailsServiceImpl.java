package simplecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        if(!username.equals("冯冠栋")) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        //比较密码，匹配成功会返回UserDetails，实际上也会去数据库查
        String password = passwordEncoder.encode("11111111");
        User user = new User(username,password, AuthorityUtils.
                commaSeparatedStringToAuthorityList("ycz,admin"));
        return user;
    }

}


