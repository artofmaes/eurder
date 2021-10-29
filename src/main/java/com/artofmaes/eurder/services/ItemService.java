package com.artofmaes.eurder.services;

import com.artofmaes.eurder.api.dto.item.CreateItemDto;
import com.artofmaes.eurder.api.dto.item.ItemDto;
import com.artofmaes.eurder.api.dto.mappers.ItemMapper;
import com.artofmaes.eurder.api.dto.mappers.UserMapper;
import com.artofmaes.eurder.domain.Item;
import com.artofmaes.eurder.repositories.ItemRepository;
import com.artofmaes.eurder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserService userService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService = userService;
    }

    public ItemDto createNewItem(CreateItemDto createItemDto, String adminId){
       userService.assertAdminId(adminId);
        Item item = new Item(createItemDto.getName(), createItemDto.getDescription(),
                createItemDto.getPrice(), createItemDto.getStock());
        itemRepository.addItem(item);
       return itemMapper.toDTO(item);
    }
}
