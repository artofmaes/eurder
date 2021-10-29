package com.artofmaes.eurder.api.controller;

import com.artofmaes.eurder.api.dto.item.CreateItemDto;
import com.artofmaes.eurder.api.dto.item.ItemDto;
import com.artofmaes.eurder.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestHeader(value = "adminId") String adminId, @RequestBody CreateItemDto createItemDto){
        logger.info("Trying to create an item...");
        return itemService.createNewItem(createItemDto, adminId);
    }

    //PUT


    //GET

}
