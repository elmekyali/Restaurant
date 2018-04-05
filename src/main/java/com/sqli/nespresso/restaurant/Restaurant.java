package com.sqli.nespresso.restaurant;

import com.sqli.nespresso.restaurant.entities.Table;

import java.util.*;

public class Restaurant {

    private List<Table> tables = new ArrayList<>();


    public int initTable(int numberOfPlaces) {
        Table table = new Table(numberOfPlaces);
        tables.add(table);
        return tables.size() - 1;
    }

    public void customerSays(int tableId, String customerOrder) {
        tables.get(tableId).addCustomerOrder(customerOrder);
    }

    public String createOrder(int tableId) {
        return "";
    }
}
