package byzilio;

import java.io.PrintStream;
import java.util.Scanner;

public class Arrays {

    int[] m;
   // int n;

    public Arrays(int n){
        m = new int[n];
        for(int i = 0; i < n; i++){
            m[i] = 0;
        }
   //     this.n = n;
    }


    public int get(int x){
        return m[x];
    }

    public void set(int x,int i){
        m[x] = i;
    }

    public void write(PrintStream ps){
        for (int aM : m) {
            ps.print(aM + " ");
        }
    }

    public void read(Scanner sc){
        int a,b;
        while(true){
            a = sc.nextInt();
            if(a > 0) {
                b = sc.nextInt();
                m[a] = b;
            }
            else break;
        }
        //m[sc.nextInt()] = sc.nextInt();
    }

    public int sum() {
        int sum = 0;
        for (int j = 0; j < m.length; j++)
                sum += m[j];
        return sum;
    }

    public int countOfEven(){
        int count = 0;
        for (int aM : m) {
            if ((aM % 2 == 0))
                count++;
        }
        return count;
    }

    public int segment(int a,int b){
        if( b >= a ) return b - a;
        else return a - b;
    }

    public boolean allPossitive(){
        for (int aM : m) {
            if (aM <= 0)
                return false;
        }
        return true;
    }

    public void reverse(){
        int n = m.length / 2;
        for(int i = 0; i < n;i++){
            int k = m[i];
            m[i] = m[m.length - i - 1];
            m[m.length - i - 1] = k;
        }
    }


}
