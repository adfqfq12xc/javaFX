package com.example.demo7.pay;

public class PayFactory {
    public paymant payFactory(String request) {
        if (request.equals("Paypal")) {
            return new paypal();
        }
        return new CreditCard();

    }
}

