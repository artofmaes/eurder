package com.artofmaes.eurder.api.dto.item;

import com.artofmaes.eurder.domain.Item;

public class ItemDto {
    private final String itemId;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;
    private final Item.StockSize stockSize;

    public ItemDto(String itemId, String name, String description, double price, int stock, Item.StockSize stockSize) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.stockSize = stockSize;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Item.StockSize getStockSize() {
        return stockSize;
    }
}
