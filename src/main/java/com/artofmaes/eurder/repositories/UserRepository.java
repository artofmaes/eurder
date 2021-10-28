package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public final ConcurrentHashMap<String, User> userList = new ConcurrentHashMap<>();

    public void addUser(User user) {
        userList.put(user.getUserId(), user);
    }

    public List<User> getUsers(){
        return new ArrayList<>(userList.values());
    }

    public User getUser(String userId){
        return userList.get(userId);
    }
}
