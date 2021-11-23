package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findUserByUserId(int userId);

}
