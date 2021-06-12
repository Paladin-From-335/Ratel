package com.github.ratel.dto;

import com.github.ratel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDto {

    private String login;

    private String password;

    public UserAuthDto(User user) {
        this.login = user.getEmail();
        this.password = user.getPassword();
    }
}
