package com.tobadigitalstudio.inventory.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "warehouse")
public class Warehouse {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "barcode")
    private String barcode;

    @ColumnInfo(name = "item_name")
    private String itemName;

    @ColumnInfo(name = "count")
    private Integer count;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "images")
    private String images;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    public Warehouse() {
    }

    public Warehouse(@NonNull String barcode, String itemName, Integer count, String description, String images, String createdAt) {
        this.barcode = barcode;
        this.itemName = itemName;
        this.count = count;
        this.description = description;
        this.images = images;
        this.createdAt = createdAt;
    }

    @NonNull
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(@NonNull String barcode) {
        this.barcode = barcode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
