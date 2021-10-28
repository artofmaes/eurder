package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public final ConcurrentHashMap<String, User> userList;

    public UserRepository() {
        this.userList = new ConcurrentHashMap<>();
    }

    public User addUser(User user){
        userList.put(user.getUserId(), user);
        return user;
    }
}
