package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.mappers.UserMapper;
import com.artofmaes.eurder.api.dto.user.CreateUserDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService = new UserService(new UserRepository(), new UserMapper());


    @Test
    void whenCreatingUser_ReturnACorrectlyFilledUserDto() {
        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
                "", "", "12340", "", "");

        UserDto createdUser = userService.createNewUser(createUserDto);

        Assertions.assertNotNull(createdUser.getUserId());
        Assertions.assertEquals("Bobby", createdUser.getFirstName());
        Assertions.assertEquals("From da Block", createdUser.getLastName());
        Assertions.assertEquals("bobby@fromdablock.com", createdUser.getMailAddress());
        Assertions.assertEquals("12340", createdUser.getPostalCode());
    }
}
