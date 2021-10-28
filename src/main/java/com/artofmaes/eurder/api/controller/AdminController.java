package com.artofmaes.eurder.api.controller;

import com.artofmaes.eurder.api.dto.user.CreateAdminDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admins")
public class AdminController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createAdmin(@RequestBody CreateAdminDto createAdminDto) {
        logger.info("Creating a new admin for email: " + createAdminDto.getMailAddress());
        return userService.createNewAdmin(createAdminDto);
    }
}
