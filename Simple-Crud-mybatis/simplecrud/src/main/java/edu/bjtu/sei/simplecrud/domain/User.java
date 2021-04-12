package edu.bjtu.sei.simplecrud.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class User {

    private String user_id_num;

    private String user_name;
    private String user_password;
    private String user_phone_num;
    private  Collection<Role> roles;

    public User() {
    }

    public User(String user_name, String user_password, String user_phone_num, Collection<Role> roles) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone_num = user_phone_num;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id_num +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + "*********" + '\'' +
                ", roles='" + roles + '\'' +
                ", user_phone_num='" + user_phone_num + '\'' +
                '}';
    }
}
