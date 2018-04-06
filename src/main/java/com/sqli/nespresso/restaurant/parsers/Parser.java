package com.sqli.nespresso.restaurant.parsers;

import com.sqli.nespresso.restaurant.entities.CustomerOrder;

public interface Parser {
    CustomerOrder customerOrderParser (String customerOrder , String separator);
    String[]      orderParser (String order , String separator);
}
