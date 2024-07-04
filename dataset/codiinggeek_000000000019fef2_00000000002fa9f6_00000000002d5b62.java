/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static long mod = (long)Math.pow(10,9) + 7;
    public static void main(String[] args) {
        try {
            FastReader s = new FastReader();
            int  t = s.nextInt();
            int m=1;
            while(t-->0){
                long x = s.nextInt();
                long y = s.nextInt();
                if(Math.abs(x)+Math.abs(y)==1||Math.abs(x)+Math.abs(y)==3){
                    if(Math.abs(x)+Math.abs(y)==1){
                        if(x==0&&y==1){
                            System.out.println("Case #" + m + ": "+"N");
                        }else if(x==0&&y==-1){
                            System.out.println("Case #" + m + ": "+"S");
                        }else if(x==1&&y==0){
                            System.out.println("Case #" + m + ": "+"E");
                        }else if(x==-1&&y==0){
                            System.out.println("Case #" + m + ": "+"W");
                        }
                    }else {
                        String s1 = "", s2="";
                        String ans ="";
                        if(x>=0&&y>=0){
                            s1="N";
                            s2="E";
                        }else if(x<=0&&y<=0){
                            s1="S";
                            s2="W";
                        }else if(x<=0&&y>=0){
                            s1 = "N";
                            s2 = "W";
                        }else if(x>=0&&y<=0){
                            s1="S";
                            s2 = "E";
                        }
                        x = Math.abs(x);
                        y = Math.abs(y);
                        if(x==3&&y==0){
                            ans = s2+s2;
                        }else if(y==3&&x==0){
                            ans = s1+s1;
                        }else if(x==1&&y==2){
                            ans = s2+s1;
                        }else {
                            ans = s1+s2;
                        }
                        System.out.println("Case #" + m + ": "+ans);
                    }
                }else {
                    System.out.println("Case #" + m + ": "+"IMPOSSIBLE");
                }
                m++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    /**Pair class */
    class Pair<U, V> {
        U first;
        V second;

        Pair(U a, V b) {
            first = a;
            second = b;
        }
    }
/**---------------------------------------------------------------------------------*/
    /** FAST I/O */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
} 
