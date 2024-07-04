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
            int q = 1;
            while(t-->0){
                int n = s.nextInt();
                String ar[] = new String[n];
                for(int i=0;i<n;i++){
                    ar[i] = s.next();
                }
                String s1 = ar[0];
                int l1=0;
                String maxs = "";
                String mins = "";
                int xx = 0;
                for(int i=1;i<n;i++){
                    String s2 = ar[i];
                   // System.out.println(s1+" "+s2);
                    if(s2.compareTo(s1)==0){
                        xx++;
                        continue;
                    }
                    l1 = s1.length();
                    int l2 = s2.length();
                    int maxl = Math.max(l1,l2);
                    int minl = Math.min(l1,l2);
                    if(maxl == l1){
                        maxs = s1;
                        mins = s2;
                    }else{
                        maxs = s2;
                        mins = s1;
                    }
                    int m = maxl;
                    int y=0;
                    for(int j=minl-1;j>=1;j--){
                        if(maxs.charAt(m-1)==mins.charAt(j)){
                            y++;
                        }else{
                            break;
                        }
                        m--;
                    }
                   // System.out.println(y+" "+minl+" "+maxs+" "+mins);
                    if(y!=minl-1){
                        break;
                    }
                    s1 = maxs;
                    xx++;
                   // System.out.println(xx+" "+maxs+" "+mins);
                   // System.out.println();
                }
                if(xx==n-1){
                    System.out.println("Case #"+q+": "+maxs.substring(1));
                }else{
                    System.out.println("Case #"+q+": "+"*");
                }
                q++;
            }
        } catch (Exception e) {
            return;
        }
    }
} 
