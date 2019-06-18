package com.dawn.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Console;

@Setter@Getter
public class User {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
