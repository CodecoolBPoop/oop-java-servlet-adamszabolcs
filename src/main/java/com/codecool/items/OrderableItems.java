package com.codecool.items;

import java.util.ArrayList;
import java.util.List;

public class OrderableItems {

    public static List<Item> createItems() {
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("GSW Jersey S", 150.0));
        itemList.add(new Item("GSW Jersey M", 155.0));
        itemList.add(new Item("GSW Jersey L", 160.0));
        itemList.add(new Item("GSW Jersey XL", 170.0));
        itemList.add(new Item("GSW Jersey XXL", 200.0));
        return itemList;
    }

}
