package com.sqli.nespresso.restaurant.entities;

import com.sqli.nespresso.restaurant.parsers.DefaultParser;
import com.sqli.nespresso.restaurant.parsers.Parser;
import com.sqli.nespresso.restaurant.presenters.DefaultPresenter;
import com.sqli.nespresso.restaurant.presenters.Presenter;

import java.util.*;

public class Table {

    private Map<String , CustomerOrder> customerOrderMap;
    private String lastOrder = "";
    private int numberOfPlaces;
    private Parser parser = new DefaultParser();
    private Presenter presenter = new DefaultPresenter();

    public Table(int numberOfPlaces) {
        customerOrderMap = new LinkedHashMap<>(numberOfPlaces);
        this.numberOfPlaces = numberOfPlaces;
    }

    public void addCustomerOrder (String customerOrderInput) {
        CustomerOrder customerOrder = parser.customerOrderParser(customerOrderInput , ": ");
        customerOrder.setOrder(customerOrder.getOrder().equals("Same") ? lastOrder : customerOrder.getOrder());
        lastOrder = customerOrder.getOrder();
        customerOrderMap.put(customerOrder.getCustomerName() , customerOrder);
    }

    public String createOrder () {
        return presenter.orderPresenter(customerOrderMap , numberOfPlaces);
    }
}
