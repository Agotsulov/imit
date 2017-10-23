package com.byzilio.arrays;

import java.io.*;

public class FinanceReport {

    Payment payments[];

    InputStream in = System.in;
    OutputStream out = System.out;

    public FinanceReport(Payment[] payments) {
        this.payments = payments;
    }

    public FinanceReport(int l) {payments = new Payment[l];
    }

    public FinanceReport() {
        payments = new Payment[10];
    }

    public FinanceReport(FinanceReport fr) {
        this.payments = fr.payments.clone();
    }


    public void found(char c) throws IOException {
        for(int i = 0;i < payments.length;i++){
            if(payments[i].name.charAt(0) == c) {
                Payment p = payments[i];
                String o = String.format("Плательщик: %s дата: %d.%d.%d сумма: %d руб. %d коп. \n",
                        p.name,p.day,p.month,p.year,p.amount/100,p.amount%100);
                out.write(o.getBytes());
            }
        }
    }

    public int sumDate(String date){
        int result = 0;
        String s[] = date.split(".");
        int d = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        for(int i = 0;i < payments.length;i++){
            if((payments[i].day == d) && (payments[i].month == m) && (payments[i].year == y)) {
                result += payments[i].amount;
            }
        }
        return result;
    }

    public void foundLess(int sum) throws IOException {
        for(int i = 0;i < payments.length;i++){
            if(payments[i].amount < sum) {
                Payment p = payments[i];
                String o = String.format("Плательщик: %s дата: %d.%d.%d сумма: %d руб. %d коп.",
                        p.name,p.day,p.month,p.year,p.amount/100,p.amount%100);
                out.write(o.getBytes());
            }
        }
    }

    public String[] getMonthsWithOutP(int y){
        String r[] = {"Январь",	"Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        boolean t[] = new boolean[12];
        for(int i = 0;i< payments.length;i++){
            t[payments[i].month]= false;
        }

        int lel = 0;
        for(int i = 0;i< 12;i++){
            if(t[i] == true) lel++;
        }

        String s[] = new String[lel];
        for(int i = 0;i< 12;i++){
            s[i] = r[i];
        }


        return s;
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
