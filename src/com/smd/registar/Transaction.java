package com.smd.registar;

public class Transaction {
	String paymentInfo;

	String getPaymentInfo() {
		return paymentInfo;
	}

	void processPaymentInfo(String pay) {
		if (pay.length() == 16) {
			System.out.println("Your transaction has been" + "processed.\n\nThankYou");
		} else {
			System.out.println("Your payment information is incorrect" + "please use a valid 16 digit card number.");

		}
	}
}
