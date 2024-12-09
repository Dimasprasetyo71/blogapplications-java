package com.blogapplication.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapplication.Repo.UserRepo;
import com.blogapplication.entities.User;
import com.blogapplication.exception.ResourceNotFoundException;
import com.blogapplication.payload.UserDto;
import com.blogapplication.service.UserService;

@Service 
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    /**
     * Create a new user with the given userDto
     * @param userdto the user data transfer object
     * @return the created userDto
     */
    @Override
    public UserDto createUser(UserDto userdto) {
        User map = this.modelMapper.map(userdto, User.class);
        User  addedUser = this.userRepo.save(map);

        return this.modelMapper.map(addedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        cat.setName(userDto.getName());
        cat.setEmail(userDto.getEmail());
        cat.setPassword(userDto.getPassword());
        cat.setAge(userDto.getAge());
        cat.setGender(userDto.getGender());
        User updatedCat = this.userRepo.save(cat);
        return this.modelMapper.map(updatedCat, UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return this.modelMapper.map(cat, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map((user)->this.modelMapper.map(user, UserDto.class)).toList();
        return userDtos;
    }
    
    @Override
    public UserDto getUserByEmail(String email) {
        List<UserDto> userDtos = this.getAllUsers();
        return userDtos.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User", "Email", 0));
    }

    @Override
    public void deleteUser(Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(cat);
    }



}
