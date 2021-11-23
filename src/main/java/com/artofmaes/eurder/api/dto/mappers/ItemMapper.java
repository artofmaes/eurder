package com.artofmaes.eurder.api.dto.mappers;

import com.artofmaes.eurder.api.dto.item.ItemDto;
import com.artofmaes.eurder.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toDTO(Item item){
        return new ItemDto.Builder()
                .withItemId(item.getItemId())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice())
                .withStock(item.getStock())
                .withStockSize(item.getStockSize())
                .build();
    }

    public Item toEntity(ItemDto itemDto){
        return new Item.Builder()
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withPrice(itemDto.getPrice())
                .withStock(itemDto.getStock())
                .withStockSize(itemDto.getStockSize())
                .build();
    }
}
