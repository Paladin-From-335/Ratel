package com.github.ratel.controllers;

import com.github.ratel.dto.UserAuthDto;
import com.github.ratel.dto.UserRegDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserControllerAuthentication {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserAuthDto> findAll();

    @PostMapping
    UserRegDto save(@RequestBody UserRegDto payload);
}
