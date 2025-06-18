package com.praktikum.data;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static DataStore instance;

    private List<String[]> lostItems;

    private DataStore() {
        lostItems = new ArrayList<>();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public void addLostItem(String namaBarang, String lokasi, String tanggal, String keterangan) {
        lostItems.add(new String[]{namaBarang, lokasi, tanggal, keterangan});
    }

    public List<String[]> getLostItems() {
        return lostItems;
    }

    public void removeLostItem(int index) {
        if (index >= 0 && index < lostItems.size()) {
            lostItems.remove(index);
        }
    }
}
