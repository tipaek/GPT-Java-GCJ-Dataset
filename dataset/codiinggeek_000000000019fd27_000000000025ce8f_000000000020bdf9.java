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
                int n = s.nextInt();
                //int f1=0,f2=0;
                long l = s.nextLong();
                long r = s.nextLong();
                n--;
                String ss = "C";
                //f1 = 1;
                long x=0,y=0;
                int p=0;
                while(n-->0){
                    long a = s.nextLong();
                    long b = s.nextLong();
                    if((l<=a&&a<r)||(l<b&&b<=r)){
                        if((x<=a&&a<y)||(x<b&&b<=y)){
                            p=-1;
                            break;
                        }else{
                            x = a;
                            y = b;
                            ss += "J";
                        }
                    }else{
                        l = a;
                        r = b;
                        ss +="C";
                    }
                }
                if(p==-1)
                    System.out.println("Case #"+m+": "+"IMPOSSIBLE");
                else
                    System.out.println("Case #"+m+": "+ss);
                m++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
