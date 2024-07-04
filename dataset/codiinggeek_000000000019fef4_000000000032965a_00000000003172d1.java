/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static long mod = (long)Math.pow(10,9);
    public static void main(String[] args){
        try{
            FastReader s = new FastReader();
            int t = s.nextInt();
            int m=1;
            while(t-->0){
                int n = s.nextInt();
                double d = (double)s.nextLong();
                HashMap<Double, Long> mp = new HashMap<>();
                HashSet<Double> st = new HashSet<>();
                for(int i=0;i<n;i++){
                    double a = s.nextLong();
                    mp.put(a, mp.getOrDefault(a,0l)+1);
                    st.add(a);
                }
                Iterator<Double> itr = st.iterator();
                int p=0;
                while(itr.hasNext()){
                    double v = itr.next();
                    if(mp.get(v)==d){
                        p=1;
                        break;
                    }
                }
                if(p==1){
                    System.out.println("Case #" + m + ": " +0 );
                    m++;
                    continue;
                }
                if(d==2){
                    System.out.println("Case #" + m + ": " +1 );
                    m++;
                    continue;
                }
                int y= 0;
                Iterator<Double> its = st.iterator();
                while(its.hasNext()){
                    double v = its.next();
                    double a = v/2;
                    if(st.contains(a)){
                        y=1;
                        break;
                    }
                }
                if(y==1)
                    System.out.println("Case #" + m + ": " +1 );
                else
                    System.out.println("Case #" + m + ": " +2 );
                m++;
            }
        }catch(Exception e){
            System.out.println(e);
            return ;
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
