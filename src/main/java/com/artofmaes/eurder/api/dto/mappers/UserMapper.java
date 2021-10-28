package com.artofmaes.eurder.api.dto.mappers;

import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public Collection<UserDto> toDTO(Collection<User> users){
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserDto toDTO(User user){
        return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getMailAddress(), user.getStreet(), user.getStreetNumber(),user.getPostalCode(),user.getCity(),user.getPhoneNumber(), user.isAdmin());
    }

    public User toEntity(UserDto userDto){
        return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getMailAddress(), userDto.getStreet(), userDto.getStreetNumber(),userDto.getPostalCode(),userDto.getCity(),userDto.getPhoneNumber());
    }
}
