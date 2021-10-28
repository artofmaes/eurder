package com.artofmaes.eurder.api.dto.item;

public class CreateItemDto {
    private final String name;
    private final String description;
    private final double price;
    private final int stock;

    public CreateItemDto(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
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
}
