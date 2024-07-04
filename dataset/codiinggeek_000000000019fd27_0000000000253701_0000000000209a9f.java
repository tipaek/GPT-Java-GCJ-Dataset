/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
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

    public static void main(String[] args) {
        try {
            FastReader s = new FastReader();
            int t = s.nextInt();
            int m=1;
            while(t-->0){
                String ss = s.next();
                int lb=0,rb=0;
                int l = ss.length();
                String ans="";
                int i=0;
              //  int prev=0;
                while(i<l){
                    int a = (int)ss.charAt(i)-48;
                    if(a>lb){
                        while(a>lb){
                            ans +="(";
                            lb++;
                        }
                    }else{
                        while(lb>a){
                            ans +=")";
                            lb--;
                        }
                    }
                    ans += a;
                    i++;
                }
                while(lb>0){
                    ans +=")";
                    lb--;
                }

                System.out.println("Case #"+m+": "+ans);
                m++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
