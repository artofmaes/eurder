package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.item.CreateItemDto;
import com.artofmaes.eurder.api.dto.mappers.ItemMapper;
import com.artofmaes.eurder.api.dto.mappers.UserMapper;
import com.artofmaes.eurder.api.dto.user.CreateAdminDto;
import com.artofmaes.eurder.api.dto.user.CreateUserDto;
import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.domain.exceptions.UnauthorizedUserException;
import com.artofmaes.eurder.repositories.ItemRepository;
import com.artofmaes.eurder.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemServiceTest {

    UserService userService = new UserService(new UserRepository(), new UserMapper());
    ItemService itemService = new ItemService(new ItemRepository(),new ItemMapper(), userService);


    @Test
    void whenAddingAnItem_ThrowExceptionWhenUserIsNotAdmin(){
        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
                "", "", "12340", "", "");
        UserDto member = userService.createNewUser(createUserDto);

        CreateItemDto createItemDto = new CreateItemDto("Banana","Nice yellow bananas from the wonderful south", 1.99, 16);
        Assertions.assertThrows(UnauthorizedUserException.class, () -> itemService.createNewItem(createItemDto, member.getUserId()));

    }

    @Test
    void whenAddingAnItem_ReturnItemWhenUserIsAdmin(){
        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
                "", "", "12340", "", "");
        UserDto admin = userService.createNewAdmin(createAdminDto);

        CreateItemDto createItemDto = new CreateItemDto("Banana","Nice yellow bananas from the wonderful south", 1.99, 16);
        Assertions.assertDoesNotThrow(() ->itemService.createNewItem(createItemDto, admin.getUserId()));

    }
}
