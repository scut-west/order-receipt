package org.katas.refactoring;

import java.util.List;

public class Order {
    Customer customer;
    List<LineItem> lineItems;

    public Order(Customer customer, List<LineItem> lineItems) {
        this.customer = customer;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return this.customer.getCustomerName();
    }

    public String getCustomerAddress() {
        return this.customer.getCustomerAddress();
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    String generateCustomerInfo() {
        return getCustomerName() + getCustomerAddress();
    }

    double calculateTotalSalesTax() {
        return getLineItems().stream().mapToDouble(lineItem -> lineItem.totalAmount() * .10).sum();
    }

    double calculateTotalAmount() {
        return getLineItems().stream().mapToDouble(lineItem -> lineItem.totalAmount() * .10 + lineItem.totalAmount()).sum();
    }
}
