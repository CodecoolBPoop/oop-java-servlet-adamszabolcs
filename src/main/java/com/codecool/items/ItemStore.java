package com.codecool.items;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {

    public static List<Item> itemList = new ArrayList<>();

    private static void add(Item item) {
        itemList.add(item);
    }

    private static void remove(Item item) {
        itemList.remove(item);
    }
}
