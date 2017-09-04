package com.byzilio;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Basics {
    public static void average() throws FileNotFoundException {
        Scanner sc;
        sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        System.out.println((double) (a + b + c) / 3.0d);

        if(b > a) {
            double k = a;
            a = b;
            b = k;
        }


        if(c > a) {
            double k = a;
            a = c;
            c = k;
        }

        if(c > b){
            double k = b;
            b = c;
            c = k;
        }


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    public void third()throws FileNotFoundException {
        Scanner sc;
        sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        System.out.println((a + b + c) / 3);

        if(b > a) {
            int k = a;
            a = b;
            b = k;
        }


        if(c > a) {
            int k = a;
            a = c;
            c = k;
        }

        if(c > b){
            int k = b;
            b = c;
            c = k;
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    public void fourth(){
        Scanner sc;
        sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double D = b*b - 4 * a * c;
        double x1, x2;

        if(D > 0) {
            x1 = ( -b + Math.sqrt(D) ) / 2 * a;
            x2 = ( -b -  Math.sqrt(D) ) / 2 * a;
            System.out.println("Корни:" + x1 + " " + x2);

        }
        if(D ==  0) {
            x1 = ( -b ) / 2 * a;
            System.out.println("Корень:" + x1);

        }
        if(D < 0){
            System.out.println("Нет корней");
        }
    }

    public void fifth(){
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Введите диапазон:");
        double s = sc.nextDouble(), e = sc.nextDouble();
        System.out.println("Введите шаг:");
        double step = sc.nextDouble();
        System.out.println();
        for(double d = s;d <= e;d = d + step){
            System.out.println("Sin(" + d + ") = " + Math.sqrt(d));
        }
    }

    public void sixth(){
        Scanner sc;
        sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double d = sc.nextDouble(), e = sc.nextDouble(), f = sc.nextDouble();
        double x , y;
        y = (a * f - c * d)/(a * e - b * d);
        x = (c * e - b * f)/(a * e - b * d);
        System.out.println("Неизвестные: x = "+ x + " y = " + y);
    }

    public void seventh(){
        Scanner sc;
        sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double t = sc.nextDouble();
        double sum = 0;
        double next;
        double i = 0;
        while(true){
            double fact = 1;
            for( int k = 2; k <= i;k++){
                fact *= k;
            }
            next = Math.pow(x,i) / fact;
            sum += next;
            if(Math.abs(next) < t) break;

            i++;
        }

        System.out.println(sum);
    }
}
