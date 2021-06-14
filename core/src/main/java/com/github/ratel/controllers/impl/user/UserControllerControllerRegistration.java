package com.github.ratel.controllers.impl.user;

import com.github.ratel.controllers.IUserControllerRegistration;
import com.github.ratel.dto.UserAuthDto;
import com.github.ratel.dto.UserRegDto;
import com.github.ratel.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/registration")
@RequiredArgsConstructor
public class UserControllerControllerRegistration implements IUserControllerRegistration {

    private UserService userService;

    @Override
    public List<UserAuthDto> findAll() {
        return null;
    }

    @Override
    public UserRegDto save(UserRegDto payload) {
        return null;
    }

}
