package com.artofmaes.eurder.api.dto.mappers;

import com.artofmaes.eurder.api.dto.user.UserDto;
import com.artofmaes.eurder.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDTO(User user) {
        return new UserDto.Builder()
                .withUserId(user.getUserId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withStreet(user.getStreet())
                .withStreetNumber(user.getStreetNumber())
                .withPostalCode(user.getPostalCode())
                .withCity(user.getCity())
                .withPhoneNumber(user.getPhoneNumber())
                .withMailAddress(user.getMailAddress())
                .withAdmin(user.isAdmin())
                .build();
    }

    public User toEntity(UserDto userDto) {
        return new User.Builder()
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withStreet(userDto.getStreet())
                .withStreetNumber(userDto.getStreetNumber())
                .withPostalCode(userDto.getPostalCode())
                .withCity(userDto.getCity())
                .withPhoneNumber(userDto.getPhoneNumber())
                .withMailAddress(userDto.getMailAddress())
                .withAdmin(userDto.isAdmin())
                .build();
    }
}
