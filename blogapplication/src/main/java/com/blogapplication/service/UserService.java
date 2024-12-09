package com.blogapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogapplication.payload.UserDto;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);
  
    UserDto updateUser(UserDto userDto, Integer userId);
  
    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto getUserByEmail(String email);

    void deleteUser(Integer userId);

}
