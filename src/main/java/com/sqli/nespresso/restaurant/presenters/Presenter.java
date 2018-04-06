package com.sqli.nespresso.restaurant.presenters;

import com.sqli.nespresso.restaurant.entities.CustomerOrder;

import java.util.*;

public interface Presenter {
    String orderPresenter(Map<String, CustomerOrder> customerOrderMap , int numberOfPlaces);
    String missingOrderPresenter(Map<String, CustomerOrder> customerOrderMap , int numberOfPlaces);
}
