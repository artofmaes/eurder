//package com.artofmaes.eurder.services;
//
//import com.artofmaes.eurder.api.dto.mappers.UserMapper;
//import com.artofmaes.eurder.api.dto.user.CreateAdminDto;
//import com.artofmaes.eurder.api.dto.user.CreateUserDto;
//import com.artofmaes.eurder.api.dto.user.UserDto;
//import com.artofmaes.eurder.domain.exceptions.UnauthorizedUserException;
//import com.artofmaes.eurder.repositories.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class UserServiceTest {
//
//    UserService userService = new UserService(new UserRepository(), new UserMapper());
//
//
//    @Test
//    void whenCreatingUser_ReturnACorrectlyFilledUserDto() {
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//
//        UserDto createdUser = userService.createNewUser(createUserDto);
//
//        Assertions.assertNotNull(createdUser.getUserId());
//        Assertions.assertEquals("Bobby", createdUser.getFirstName());
//        Assertions.assertEquals("From da Block", createdUser.getLastName());
//        Assertions.assertEquals("bobby@fromdablock.com", createdUser.getMailAddress());
//        Assertions.assertEquals("12340", createdUser.getPostalCode());
//    }
//
//    @Test
//    void whenCallingAllUsers_ThrowExceptionsIfUserCallingTheMethodIsNotAdmin(){
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto userThatIsNotAdmin = userService.createNewUser(createUserDto);
//        Assertions.assertThrows(UnauthorizedUserException.class, () -> userService.getAllUsers(userThatIsNotAdmin.getUserId()));
//    }
//
//    @Test
//    void whenCallingSpecificUser_ThrowExceptionsIfUserCallingTheMethodIsNotAdmin(){
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        CreateUserDto createUserDto2 = new CreateUserDto("Franky", "From da Block", "franky@fromdablock.com",
//                "", "", "12340", "", "");
//
//        UserDto userThatIsNotAdmin = userService.createNewUser(createUserDto);
//        UserDto user = userService.createNewUser(createUserDto2);
//        Assertions.assertThrows(UnauthorizedUserException.class, () -> userService.getSpecificUser(userThatIsNotAdmin.getUserId(), user.getUserId()));
//    }
//
//
//    @Test
//    void whenCallingAllUsersAsAdmin_ShowAllMembersList(){
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto user1 = userService.createNewUser(createUserDto);
//
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        List<UserDto> users = userService.getAllUsers(admin.getUserId());
//        Assertions.assertTrue(users.stream().anyMatch(user -> user.getUserId().equals(user1.getUserId())));
//    }
//
//    @Test
//    void whenCallingSpecificUserAsAdmin_ShowSpecificMember(){
//        CreateUserDto createUserDto = new CreateUserDto("Bobby", "From da Block", "bobby@fromdablock.com",
//                "", "", "12340", "", "");
//        UserDto user1 = userService.createNewUser(createUserDto);
//
//        CreateAdminDto createAdminDto = new CreateAdminDto("Franky", "From da Hill", "franky@fromdahill.com",
//                "", "", "12340", "", "");
//        UserDto admin = userService.createNewAdmin(createAdminDto);
//
//        UserDto user = userService.getSpecificUser(admin.getUserId(), user1.getUserId());
//        Assertions.assertEquals(user.getMailAddress(), user1.getMailAddress());
//    }
//
//
//
//}
