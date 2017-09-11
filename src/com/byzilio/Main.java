package byzilio;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.print("Введите номер задания:");
        Basics b = new Basics();
        Scanner sc = new Scanner(System.in);
        //int task = sc.nextInt();
        //if(task == 1) System.out.println("Hello");
        //if(task == 2) b.average();
        //if(task == 3)b.third();
        //if(task == 4)b.fourth();
        //if(task == 5)b.fifth();21
        //if(task == 6)b.sixth();
        //if(task == 7)b.seventh();


        int n = sc.nextInt();
        Arrays a = new Arrays(n);
//        a.set(3, 3);
//        a.set(4, 22);
//        a.set(8, -12);

        a.read(sc);
        a.write(System.out);
        System.out.println("Сумма всех = " + a.sum());
        System.out.println("Кол-во четных = " + a.countOfEven());
        int A = sc.nextInt(), B = sc.nextInt();
        System.out.println("Кол-во на отрезке = " + a.segment(A,B));
        System.out.println("Позитивчик = " + a.allPossitive());

        a.reverse();
        a.write(System.out);
    }


}
