package com.byzilio.string;

class NegativeException extends Exception{
    public NegativeException() {
        //initCause(e);
        System.out.println("Less than zero");
    }
}


public class StringProcessor {


    public static String repeat(String s,int N) throws NegativeException {
        String r = new String();
        if(N < 0) {
            throw new NegativeException();
        }
        for(int i = 0;i < N;i++){
            r += s;
        }
        return r;
    }

    public int indexOf(String s,String f){
        int result = 0;
        int last = 0;

        while(s.indexOf(f,last) != -1) {
            int r = s.indexOf(f,last);
            result++;
            last = r + 1;
        }

        return result;
    }

    public String replace(String s){
        String r = new String();

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '1'){
                r+= "один";
            } else if(s.charAt(i) == '2'){
                r+= "два";
            } else if(s.charAt(i) == '3'){
                r+= "три";
            } else r+= s.charAt(i);
        }

        return r;
    }

    public void deleteEven(StringBuilder sb){
        for (int i = 0; i < sb.length() ; i++) {
            sb = sb.deleteCharAt(i);
        }
    }

    public void replaceFirstLast(StringBuilder sb){
        int firstStart = 0,firstEnd = 0,lastStart = 0,lastEnd = sb.length();
        int i = 0;

        for(;i < sb.length();i++){
            if(sb.charAt(i) != ' ') {
                firstStart = i;
                break;
            }
        }
        /*
        if(sb.charAt(0) == ' ') {
            i = 1;
            firstStart = 1;
        }
        */


        for(;i < sb.length();i++){
            if(sb.charAt(i) == ' ') {
                firstEnd = i;
                break;
            }
        }


        for(i = sb.length() - 1;i > firstEnd;i--){
            if(sb.charAt(i) != ' ') {
                lastEnd = i + 1;
                break;
            }
        }

        /*
        i = sb.length() - 1;
        if(sb.charAt(sb.length() - 1) == ' ') {
            i = sb.length() - 2;
            lastEnd = sb.length() - 1;
        }
        */
        for(;i > 0;i--){
            if(sb.charAt(i) == ' ') {
                lastStart = i + 1;
                break;
            }
        }

        String s = sb.substring(firstStart,firstEnd);
        String a = sb.substring(lastStart,lastEnd);
        sb.replace(firstStart,firstEnd,a);
        sb.replace(lastStart,lastEnd,s);
    }

    public String replace16(String s){
        String m[];
        m = s.split(" ");
        String r = new String();

        for(int i = 0;i < m.length;i++){
            if(m[i].indexOf("0x") == 0){
                int d = Integer.parseInt(m[i].substring(2,m[i].length()),16);
                m[i] = new String(String.valueOf(d));
            }
            r += m[i] + " ";
        }
        StringBuilder b = new StringBuilder(r);
        b.deleteCharAt(b.length() - 1);
        r = new String(b);
        return r;
    }
}
