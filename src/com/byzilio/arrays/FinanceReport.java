package com.byzilio.arrays;

public class FinanceReport implements Cloneable {

    Payment payments[];


    public FinanceReport(Payment[] payments) {
        this.payments = payments;
    }

    public FinanceReport() {
        payments = new Payment[10];
    }



    public int countPayments(){
        return payments.length;
    }

    public Payment get(int i){
        return payments[i];
    }


    public void set(int i,Payment p){
        payments[i] = p;
    }
}
