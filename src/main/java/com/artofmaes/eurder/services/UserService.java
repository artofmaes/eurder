package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.mappers.UserMapper;
import com.artofmaes.eurder.api.dto.user.CreateAdminDto;
import com.artofmaes.eurder.api.dto.user.CreateUserDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.domain.User;
import com.artofmaes.eurder.domain.exceptions.UnauthorizedUserException;
import com.artofmaes.eurder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createNewUser(CreateUserDto createUserDto) {
        User user = new User(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getMailAddress(),
                createUserDto.getStreet(), createUserDto.getStreetNumber(), createUserDto.getPostalCode(),
                createUserDto.getCity(), createUserDto.getPhoneNumber(), false);
        userRepository.addUser(user);
        return userMapper.toDTO(user);
    }

    public UserDto createNewAdmin(CreateAdminDto createAdminDto){
        User user = new User(createAdminDto.getFirstName(), createAdminDto.getLastName(), createAdminDto.getMailAddress(),
                createAdminDto.getStreet(), createAdminDto.getStreetNumber(), createAdminDto.getPostalCode(),
                createAdminDto.getCity(), createAdminDto.getPhoneNumber(), true);
        userRepository.addUser(user);
        return userMapper.toDTO(user);
    }

    public List<UserDto> getAllUsers(String userId){
        assertAdminId(userId);
        return userRepository.getUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());

    }

    public UserDto getSpecificUser(String adminId, String userId){
        assertAdminId(adminId);
        return userMapper.toDTO(userRepository.getUser(userId));
    }

    public void assertAdminId(String userId){
        User user = fetchUserIfExist(userId);
        if(!user.isAdmin()){
            throw new UnauthorizedUserException("You are not an admin.");
        }

    }

    private User fetchUserIfExist(String userId) {
        User user = userRepository.getUser(userId);
        if(user == null){
            throw new NullPointerException("No user found.");
        }
        return user;
    }


}
