package com.artofmaes.eurder.api.controller;

import com.artofmaes.eurder.api.dto.user.CreateUserDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        logger.info("Creating a new user for email: " + createUserDto.getMailAddress());
        return userService.createNewUser(createUserDto);
    }


    //GET
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(@RequestHeader(value = "adminId") String adminId){
        logger.info("Gathering all members...");
        return userService.getAllUsers(adminId);
    }

    @GetMapping(path = "/{userId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getSpecificUser(@RequestHeader(value = "adminId") String adminId, @PathVariable String userId){
        logger.info("Getting data on specific user..");
        return userService.getSpecificUser(adminId, userId);
    }
}
