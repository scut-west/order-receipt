package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();
		output.append(generateReceintHeader());
        output.append(order.generateCustomerInfo());
		output.append(order.generateLineItemsInfo());
		appendSalesTax(output);
		appendTotalAmount(output);
		return output.toString();
	}

	private void appendTotalAmount(StringBuilder output) {
		output.append("Total Amount").append('\t').append(order.calculateTotalAmount());
	}

	private void appendSalesTax(StringBuilder output) {
		output.append("Sales Tax").append('\t').append(order.calculateTotalSalesTax());
	}

	private String generateReceintHeader() {
		return "======Printing Orders======\n";
	}
}