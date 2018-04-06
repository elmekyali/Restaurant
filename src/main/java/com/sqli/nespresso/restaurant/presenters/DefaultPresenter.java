package com.sqli.nespresso.restaurant.presenters;

import com.sqli.nespresso.restaurant.entities.CustomerOrder;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultPresenter implements Presenter {
    @Override
    public String orderPresenter(Map<String, CustomerOrder> customerOrderMap , int numberOfPlaces) {

        String missingOrderMessage = missingOrderPresenter(customerOrderMap , numberOfPlaces);

        if (!missingOrderMessage.equals("MISSING 0"))
            return missingOrderMessage;

        List<String> orders = customerOrderMap.entrySet()
                            .stream()
                            .map(customerOrderEntry -> {
                                CustomerOrder customerOrder = customerOrderEntry.getValue();
                                return customerOrder.getNumberOfOrder() == 1 ?
                                        customerOrder.getOrder() :
                                        String.join(" for " , customerOrder.getOrder() , String.valueOf(customerOrder.getNumberOfOrder()));
                            })
                            .collect(Collectors.toList());

        return String.join(", " , orders);
    }

    @Override
    public String missingOrderPresenter(Map<String, CustomerOrder> customerOrderMap , int numberOfPlaces) {

        int             missingOrder         = 0;
        List<String>    missingOrdersName    = new ArrayList<>();

        if (numberOfPlaces != customerOrderMap.size())
            missingOrder = numberOfPlaces - customerOrderMap.size();
        else
        {
            Map<String , List<CustomerOrder>> orderGroup = customerOrderMap.entrySet()
                                                                           .stream()
                                                                           .map(customerOrderEntry -> customerOrderEntry.getValue())
                                                                           .collect(Collectors.groupingBy(CustomerOrder::getOrder
                                                                                   , LinkedHashMap::new
                                                                                   , Collectors.toList()));

            orderGroup.forEach((orderName , customerOrders) -> {
                if (customerOrders.get(0).getNumberOfOrder() != 1 && customerOrders.size() != customerOrders.get(0).getNumberOfOrder()) {
                    missingOrdersName.add(String.join(
                            " for ",
                            String.valueOf(customerOrders.get(0).getNumberOfOrder() - customerOrders.size()),
                            String.join(" for " , orderName , String.valueOf(customerOrders.get(0).getNumberOfOrder()))));
                }
            } );
        }

        String allMissingOrder = missingOrdersName.size() == 0 ? "0" : String.join(" and " , missingOrdersName);

        return missingOrdersName.size() == 0 ? String.format("MISSING %d" , missingOrder) : String.format("MISSING %s" , allMissingOrder);
    }
}
