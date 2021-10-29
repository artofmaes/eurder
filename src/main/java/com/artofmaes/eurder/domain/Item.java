package com.artofmaes.eurder.domain;

import java.util.UUID;

public class Item {
    private final String itemId;
    private final StockSize stockSize;

    private String name;
    private String description;
    private double price;
    private int stock;

    public Item(String name, String description, double price, int stock) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.stockSize = setStockSize(stock);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getItemId() {
        return itemId;
    }

    public StockSize getStockSize() {
        return stockSize;
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

    private StockSize setStockSize(int stock) {
        if(stock == 0){
            return StockSize.STOCK_EMPTY;
        }else if(stock > 0 && stock < 5){
            return StockSize.STOCK_LOW;
        } else if (stock >= 5 && stock < 10) {
            return StockSize.STOCK_MEDIUM;
        }else{
            return StockSize.STOCK_HIGH;
        }
    }

    public enum StockSize{
        STOCK_HIGH,STOCK_MEDIUM,STOCK_LOW,STOCK_EMPTY
    }
}
