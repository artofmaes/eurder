package com.artofmaes.eurder.api.dto.mappers;

import com.artofmaes.eurder.api.dto.item.ItemDto;
import com.artofmaes.eurder.domain.Item;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    public Collection<ItemDto> toDTO(Collection<Item> items){
        return items.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ItemDto toDTO(Item item){
        return new ItemDto(item.getItemId(), item.getName(),item.getDescription(),item.getPrice(), item.getStock(), item.getStockSize());
    }

    public Item toEntity(ItemDto itemDto){
        return new Item(itemDto.getName(),itemDto.getDescription(),itemDto.getPrice(), itemDto.getStock());
    }
}
