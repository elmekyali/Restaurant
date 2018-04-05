package com.sqli.nespresso.restaurant.entities;

import java.util.*;

public class Table {

    private Map<String , CustomerOrder> customerOrderMap;

    public Table(int numberOfPlaces) {
        customerOrderMap = new LinkedHashMap<>(numberOfPlaces);
    }

    public void addCustomerOrder (String customerOrder) {

    }
}
