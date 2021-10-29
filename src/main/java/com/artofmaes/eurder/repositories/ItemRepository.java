package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.Item;
import com.artofmaes.eurder.domain.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    public final ConcurrentHashMap<String, Item> itemList = new ConcurrentHashMap<>();

    public void addItem(Item item) {
        itemList.put(item.getItemId(), item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemList.values());
    }

    public Item getItemById(String itemId){
       Item foundById = itemList.get(itemId);
        if(foundById == null){
            throw new ItemNotFoundException("Item with id " + itemId + " not found.");
        }
        return foundById;
    }
}
