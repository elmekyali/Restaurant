package com.sqli.nespresso.restaurant.parsers;

import com.sqli.nespresso.restaurant.entities.CustomerOrder;

public class DefaultParser implements Parser {
    @Override
    public CustomerOrder customerOrderParser(String customerOrder , String separator) {

        String[] customerOrderCompenent = customerOrder.split(separator);
        String   customerName           = customerOrderCompenent[0];
        String[] orders                 = orderParser(customerOrderCompenent[1] , " for ");
        String   order                  = orders[0];
        int      numberOfOrders         = orders.length == 1 ? 1 : Integer.parseInt(orders[1]);

        return new CustomerOrder(customerName , order , numberOfOrders);
    }

    @Override
    public String[] orderParser(String order, String separator) {
        return order.split(separator);
    }
}
