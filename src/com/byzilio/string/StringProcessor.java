package com.byzilio.string;

public class StringProcessor {


    public String repeat(String s,int N){
        String r = new String();
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
        for (int i = sb.length() - sb.length() % 2 ; i >= 0; i -= 2)
        {
            sb = sb.deleteCharAt(i);
        }
    }

    public void replaceFirstLast(StringBuilder sb){
        int firstStart = 0,firstEnd = 0,lastStart = 0,lastEnd = sb.length();
        int i = 0;
        if(sb.charAt(0) == ' ') {
            i = 1;
            firstStart = 1;
        }

        for(;i < sb.length();i++){
            if(sb.charAt(i) == ' ') {
                firstEnd = i;
                break;
            }
        }

        i = sb.length() - 1;
        if(sb.charAt(sb.length() - 1) == ' ') {
            i = sb.length() - 2;
            lastEnd = sb.length() - 1;
        }

        for(;i > 0;i--){
            if(sb.charAt(i) == ' ') {
                char cc = sb.charAt(i);
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
