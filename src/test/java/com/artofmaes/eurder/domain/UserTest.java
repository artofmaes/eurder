package com.artofmaes.eurder.domain;

import com.artofmaes.eurder.domain.exceptions.InvalidMailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void whenUserIsBeingMade_doesNotThrowExceptionIfMailIsValid(){
        Assertions.assertDoesNotThrow(() -> new User("Bobby","From da Block","bobby@fromdablock.com",
                "harlem street","90210","11230","Harlem","0800222333"));
    }

    @Test
    void whenUserIsBeingMade_ThrowsExceptionWhenMailIsInvalid(){
        //WHEN @ is missing
        Assertions.assertThrows(InvalidMailException.class, () -> new User("Bobby","From da Block","bobbyfromdablock.com",
                "harlem street","90210","11230","Harlem","0800222333"));

        //WHEN blank
        Assertions.assertThrows(InvalidMailException.class, () -> new User("Bobby","From da Block","",
                "harlem street","90210","11230","Harlem","0800222333"));
        //WHEN null
        Assertions.assertThrows(InvalidMailException.class, () -> new User("Bobby","From da Block",null,
                "harlem street","90210","11230","Harlem","0800222333"));
    }

    @Test
    void whenUserIsBeingMade_ThrowsExceptionWhenFirstNameIsEmptyOrBlank(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new User("","From da Block","",
                "harlem street","90210","11230","Harlem","0800222333"));

        Assertions.assertThrows(NullPointerException.class, ()-> new User(null,"From da Block",null,
                "harlem street","90210","11230","Harlem","0800222333"));
    }

    @Test
    void whenUserIsBeingMade_ThrowsExceptionWhenLastNameIsEmptyOrBlank(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new User("Bobby","","bobby@fromdablock.com",
                "harlem street","90210","11230","Harlem","0800222333"));

        Assertions.assertThrows(NullPointerException.class, ()-> new User("Bobby",null,"bobby@fromdablock.com",
                "harlem street","90210","11230","Harlem","0800222333"));
    }

    @Test
    void whenUserIsBeingMade_ThrowsExceptionWhenPostalCodeIsEmptyOrBlank(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new User("Bobby","From Da Block","bobby@fromdablock.com",
                "harlem street","90210","","Harlem","0800222333"));

        Assertions.assertThrows(NullPointerException.class, ()-> new User("Bobby","From Da Block","bobby@fromdablock.com",
                "harlem street","90210",null,"Harlem","0800222333"));
    }
}
