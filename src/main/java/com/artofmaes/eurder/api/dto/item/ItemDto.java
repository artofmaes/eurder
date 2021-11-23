package com.artofmaes.eurder.api.dto.item;

import com.artofmaes.eurder.domain.Item;

public class ItemDto {
    private final int itemId;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;
    private final Item.StockSize stockSize;

    public ItemDto(int itemId, String name, String description, double price, int stock, Item.StockSize stockSize) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.stockSize = stockSize;
    }

    public int getItemId() {
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


    public static final class Builder {
        private int itemId;
        private String name;
        private String description;
        private double price;
        private int stock;
        private Item.StockSize stockSize;

        public Builder withItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder withStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder withStockSize(Item.StockSize stockSize) {
            this.stockSize = stockSize;
            return this;
        }

        public ItemDto build() {
            return new ItemDto(itemId, name, description, price, stock, stockSize);
        }
    }
}
