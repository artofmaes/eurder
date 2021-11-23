//package com.artofmaes.eurder.services;
//
//import com.artofmaes.eurder.api.dto.item.CreateItemDto;
//import com.artofmaes.eurder.api.dto.item.ItemDto;
//import com.artofmaes.eurder.api.dto.item.UpdateItemDto;
//import com.artofmaes.eurder.api.dto.mappers.ItemMapper;
//import com.artofmaes.eurder.api.dto.mappers.UserMapper;
//import com.artofmaes.eurder.api.dto.user.CreateAdminDto;
//import com.artofmaes.eurder.api.dto.user.CreateUserDto;
//import com.artofmaes.eurder.api.dto.user.UserDto;
//import com.artofmaes.eurder.domain.exceptions.UnauthorizedUserException;
//import com.artofmaes.eurder.repositories.ItemRepository;
//import com.artofmaes.eurder.repositories.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class ItemServiceTest {
//
//    UserService userService = new UserService(new UserRepository(), new UserMapper());
//    ItemService itemService = new ItemService(new ItemRepository(), new ItemMapper(), userService);
//
//
//    @Test
//    void whenAddingAnItem_ThrowExceptionWhenUserIsNotAdmin() {
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto member = userService.createNewUser(createUserDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        Assertions.assertThrows(UnauthorizedUserException.class, () -> itemService.createNewItem(createItemDto, member.getUserId()));
//
//    }
//
//    @Test
//    void whenAddingAnItem_ReturnItemWhenUserIsAdmin() {
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        Assertions.assertDoesNotThrow(() -> itemService.createNewItem(createItemDto, admin.getUserId()));
//
//    }
//
//    @Test
//    void whenGettingAllItems_ThrowExceptionWhenUserIsNotAdmin() {
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto member = userService.createNewUser(createUserDto);
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        CreateItemDto createItemDto2 = new CreateItemDto("Apple", "Nice red apples from the wonderful North", 1.99, 4);
//        itemService.createNewItem(createItemDto, admin.getUserId());
//        itemService.createNewItem(createItemDto2, admin.getUserId());
//
//        Assertions.assertThrows(UnauthorizedUserException.class, () -> itemService.getAllItems(member.getUserId()));
//    }
//
//    @Test
//    void whenGettingAllItems_DoesNotThrowExceptionWhenUserIsAdmin() {
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        CreateItemDto createItemDto2 = new CreateItemDto("Apple", "Nice red apples from the wonderful North", 1.99, 4);
//        itemService.createNewItem(createItemDto, admin.getUserId());
//        itemService.createNewItem(createItemDto2, admin.getUserId());
//
//        Assertions.assertDoesNotThrow(() -> itemService.getAllItems(admin.getUserId()));
//    }
//
//    @Test
//    void whenUpdatingAnItem_ThrowsExceptionIfUserIsNotAdmin() {
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto member = userService.createNewUser(createUserDto);
//
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        ItemDto bananaItem = itemService.createNewItem(createItemDto, admin.getUserId());
//
//        UpdateItemDto updateItemDto = new UpdateItemDto("Banana", "Nice yellow bananas from the wonderful south", 1.99, 9);
//
//        Assertions.assertThrows(UnauthorizedUserException.class, () -> itemService.updateItem(updateItemDto, bananaItem.getItemId(), member.getUserId()));
//
//
//    }
//
//    @Test
//    void whenUpdatingAnItem_DoesNotThrowExceptionIfUserIsAdmin() {
//
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        CreateItemDto createItemDto = new CreateItemDto("banana", "Nice yellow bananas from the wonderful south", 1.99, 16);
//        ItemDto bananaItem = itemService.createNewItem(createItemDto, admin.getUserId());
//
//        UpdateItemDto updateItemDto = new UpdateItemDto("banana", "Nice yellow bananas from the wonderful south", 1.99, 9);
//
//        Assertions.assertDoesNotThrow(() -> itemService.updateItem(updateItemDto, bananaItem.getItemId(), admin.getUserId()));
//    }
//}
