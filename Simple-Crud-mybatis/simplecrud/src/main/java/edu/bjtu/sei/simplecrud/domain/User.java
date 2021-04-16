package edu.bjtu.sei.simplecrud.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class User {

    private int user_id;
    private String user_name;
    private String user_password;
    private int user_role;

    public User() {
    }

    public User(String user_name, String user_password, int user_role) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + "*********" + '\'' +
                ", roles='" + user_role + '\'' +
                '}';
    }
}
