package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.mappers.ItemMapper;
import com.artofmaes.eurder.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    //TODO Add new item as an admin

}
