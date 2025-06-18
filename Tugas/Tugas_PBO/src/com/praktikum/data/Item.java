package com.praktikum.data;

public class Item {
    private String name;
    private String description;
    private String location;
    private String status;

    public Item(String namaBarang, String deskripsibarang, String lokasibarang, String statusBarang ){
        name = namaBarang;
        description = deskripsibarang;
        location = namaBarang;
        status = statusBarang;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}
