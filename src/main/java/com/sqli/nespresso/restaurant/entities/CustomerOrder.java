package com.sqli.nespresso.restaurant.entities;

public class CustomerOrder {

    private     String  customerName ;
    private     String  order        ;
    private     int     numberOfOrder;

    public CustomerOrder(String customerName, String order, int numberOfOrder) {
        this.customerName = customerName;
        this.order = order;
        this.numberOfOrder = numberOfOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }
}
