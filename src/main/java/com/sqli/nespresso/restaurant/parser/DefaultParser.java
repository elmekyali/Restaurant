package com.sqli.nespresso.restaurant.parser;

import com.sqli.nespresso.restaurant.entities.CustomerOrder;

public class DefaultParser implements Parser {
    @Override
    public CustomerOrder customerOrderParser(String customerOrder , String separator) {
        
        return null;
    }

    @Override
    public String[] orderParser(String order, String separator) {
        return new String[0];
    }
}
