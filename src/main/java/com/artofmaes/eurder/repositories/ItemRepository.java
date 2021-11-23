package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ItemRepository extends CrudRepository<Item, Integer> {

    Item findItemByItemId(int itemId);
    List<Item> findAll();


}
