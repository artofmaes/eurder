package com.artofmaes.eurder.repositories;

import com.artofmaes.eurder.domain.Item;
import com.artofmaes.eurder.domain.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public Item getItemByName(String itemName){
       Item foundByName = itemList.get(itemName);
        if(foundByName == null){
            throw new ItemNotFoundException("Item with name " + itemName + " not found.");
        }
        return foundByName;
    }
}
