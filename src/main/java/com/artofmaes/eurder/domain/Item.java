package com.artofmaes.eurder.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @Column(name = "id")
    private int itemId;

    @Column(name = "item_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "stock_amount")
    private int stock;
    @Column(name = "stock_size")
    private StockSize stockSize;

    public Item() {
    }

    public Item(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.stockSize = setStockSize(stock);
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

    public StockSize getStockSize() {
        return stockSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }



    public enum StockSize{
        STOCK_HIGH,STOCK_MEDIUM,STOCK_LOW,STOCK_EMPTY
    }

    public static final class Builder {
        private String name;
        private String description;
        private double price;
        private int stock;
        private StockSize stockSize;

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

        public Builder withStockSize(StockSize stockSize) {
            this.stockSize = stockSize;
            return this;
        }

        public Item build() {
            Item item = new Item(name, description, price, stock);
            item.stockSize = this.stockSize;
            return item;
        }
    }
}
