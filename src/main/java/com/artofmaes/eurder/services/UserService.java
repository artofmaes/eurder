package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.mappers.UserMapper;
import com.artofmaes.eurder.api.dto.user.CreateUserDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.domain.User;
import com.artofmaes.eurder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createNewUser(CreateUserDto createUserDto){
        User user = new User(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getMailAddress(),
                createUserDto.getStreet(), createUserDto.getStreetNumber(), createUserDto.getPostalCode(),
                createUserDto.getCity(), createUserDto.getPhoneNumber());
        userRepository.addUser(user);
        return userMapper.toDTO(user);
    }
}
