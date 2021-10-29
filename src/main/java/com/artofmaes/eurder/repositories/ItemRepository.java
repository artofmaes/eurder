package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    public final ConcurrentHashMap<String, Item> itemList = new ConcurrentHashMap<>();

    public void addItem(Item item) {
        itemList.put(item.getItemId(), item);
    }
}
