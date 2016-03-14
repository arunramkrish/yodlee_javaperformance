package com.yodlee.refactoring;

public class ExtractMethod extends SuperExtractMethod implements InvoiceCalculator {
	ParameterObject data = new ParameterObject();
	private String name;

	void printOwing() {
		printBanner();

		String name = "something";

		// print details
		printDetails();
	}

	/* (non-Javadoc)
	 * @see com.yodlee.refactoring.InvoiceCalculator#calculateTotal()
	 */
	@Override
	public double calculateTotal() {
		double basePrice = calculateBasePrice();
		if (basePrice > 1000) {
			return basePrice * 0.95;
		} else {
			return basePrice * 0.98;
		}
	}

	private void printDetails() {
		System.out.println("name: " + getName());
		System.out.println("amount: " + getOutstanding());
	}

	private String getName() {
		return name;
	}

	private String getOutstanding() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		InvoiceCalculator em = new ExtractMethod();
		em.calculateTotal();
	}

}
