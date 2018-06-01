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

		// prints lineItems
		appendLineItemInfo(output);
		appendSalesTax(output);

		appendTotalAmount(output);
		return output.toString();
	}

	private void appendTotalAmount(StringBuilder output) {
		double totalAmount = order.calculateTotalAmount();
		// print total amount
		output.append("Total Amount").append('\t').append(totalAmount);
	}

	private void appendSalesTax(StringBuilder output) {
		double totalSalesTax = order.calculateTotalSalesTax();

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totalSalesTax);
	}

	private void appendLineItemInfo(StringBuilder output) {
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');

		}
	}

	private String generateReceintHeader() {
		return "======Printing Orders======\n";
	}
}