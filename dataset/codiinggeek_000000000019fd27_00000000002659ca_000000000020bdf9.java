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
                HashMap<Long, Long> one = new HashMap<>();
                HashMap<Long, Long> two = new HashMap<>();
                n--;
                one.put(l,r);
                String ss = "C";
                //f1 = 1;
                long x=0,y=0;
                int p=0;
                while(n-->0) {
                    long a = s.nextLong();
                    long b = s.nextLong();
                    if(p==1){
                        continue;
                    }
                    Set<Map.Entry<Long, Long>> st1 = one.entrySet();
                    int g = 0, h = 0;
                    for (Map.Entry<Long, Long> map1 : st1) {
                        if ((map1.getKey() <= a && a < map1.getValue()) || (map1.getKey() < b && b <= map1.getValue())) {
                            g = 1;
                        }
                    }
                    if (g != 1) {
                        ss += "C";
                        one.put(a, b);
                    } else {
                        Set<Map.Entry<Long, Long>> st2 = two.entrySet();
                        for (Map.Entry<Long, Long> map2 : st2) {
                            if ((map2.getKey() <= a && a < map2.getValue()) || (map2.getKey() < b && b <= map2.getValue())) {
                                h = 1;
                            }
                        }
                        if (h == 1) {
                            p = 1;
                        } else {
                            ss += "J";
                            two.put(a, b);
                        }
                    }
                }
                    /*if((l<=a&&a<r)||(l<b&&b<=r)){
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
                }*/
                if(p==1)
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
