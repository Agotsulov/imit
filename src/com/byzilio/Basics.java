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
        System.out.println((double) (a + b + c) / 3);

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
        double D = b * b - 4 * a * c;
        double x1, x2;

        if(a == 0) {
            if(b == 0) {
                if(c == 0){
                    System.out.println("Любое");
                    return;

                }
                System.out.println("Нет");
                return;
            } else {
                System.out.println("Корень:" + (-c / b));
                return;
            }

        }

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
            System.out.println("Sin(" + d + ") = " + Math.sin(d));
        }
    }

    public void sixth(){
        Scanner sc;
        sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();
        double d = sc.nextDouble(), e = sc.nextDouble(), f = sc.nextDouble();
        double x , y;

        if( ( (a == 0) && (b == 1) && (c == 0) && (d == 0) && (e == 0) && (f == 0) )
            || ((a == 0) && (b == 0) && (c == 0) && (d == 0) && (e == 1) && (f == 0))
                || ((a == 1) && (b == 0) && (c == 0) && (d == 0) && (e == 0) && (f == 0))
                    || ((a == 0) && (b == 0) && (c == 0) && (d == 1) && (e == 0) && (f == 0))
                )
        {
            System.out.println("Нет решений");
            return;
        }


        double A , B , C;

        if(a == 0)
            A = d;
        else
            A = a / d;


        if(b == 0)
            B = e;
        else
            B = b / e;


        if(c == 0)
            C = f;
        else
            C = c / f;

        if( A != B ){
            double k = (a * f - c * d);
            if(k == 0)
                y = 0;
            else y = (a * f - c * d) / (a * e - b * d);
            double l = (c * e - b * f);
            if(l == 0)
                x = 0;
            else x = (c * e - b * f) / (a * e - b * d);
            System.out.println("Неизвестные: x = " + x + " y = " + y);
        }
        if( ( A == B) && ( B == C) ) {
            System.out.println("Точки на прямой");
        }
        if( ( A == B ) && (B != C) ){
            System.out.println("Нет решений");
        }

        /*
        if( ((a == 0) && (b == 0) && (c != 0)) || ((d == 0) && (e == 0) && (f != 0)) ){
            System.out.println("Неверно!");
        } else {
            if( A != B ){
                y = (a * f - c * d) / (a * e - b * d);
                x = (c * e - b * f) / (a * e - b * d);
                System.out.println("Неизвестные: x = " + x + " y = " + y);
            } else {
                System.out.println("Любое");
            }
        }
        */
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
            System.out.println(next);
            sum += next;
            if(Math.abs(next) < t) break;

            i++;
        }

        System.out.println(sum);
        System.out.println(Math.exp(2));
    }
}
