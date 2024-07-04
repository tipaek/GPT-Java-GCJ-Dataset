//package solution;

import java.io.*;
import java.util.*;
import java.awt.Point;
import java.math.BigInteger;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception | Error ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    long mod = 998244353;
    void run() throws Exception {
        int t = ni();
        for(int I=1; I<=t; I++) {
            int n = ni(), d = ni();
            long[] slices = new long[n];
            for(int i=0; i<n; i++)
                slices[i] = nl();
            HashSet<Long> div = new HashSet<>();
            //for(long slice : slices) {
                //addDivisors(slice, div);
            //}
            addDivisors(slices, div);
            sortAndReverse(slices);
            
            //pl("Size : " + div.size());
            
            int min = d - 1;
            for(long num : div) {
                int cuts = getCuts(num, d, slices);
                if(cuts == -1) continue;
                min = Math.min(min, cuts);
            }
            
            pl("Case #" + I + ": " + min);
        }
    }
    
    void addDivisors(long num, HashSet<Long> divisors) {
        for(long i=1; i<=Math.sqrt(num)+1; i++) {
            if(num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
    }
    
    void addDivisors(long[] slice, HashSet<Long> divisors) {
        int n = slice.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                divisors.add(1L);
                divisors.add(slice[i]);
                divisors.add(gcd(slice[i], slice[j]));
            }
        }
    }
    
    int getCuts(long num, int req, long[] slices) {
        int n = slices.length, cuts = 0;
        int[] taken = new int[n];
        for(int i=0; i<n; i++) {
            if(slices[i] == num) {
                taken[i] = 1;
                req--;
                if(req <= 0)
                    return cuts;
            }
        }
        for(int i=0; i<n; i++) {
            if(taken[i] == 1) continue;
            if(slices[i] % num == 0) {
                taken[i] = 1;
                long temp = slices[i] / num;
                if(req - temp < 0) {
                    cuts += req;
                    req = 0;
                } else {
                    req -= temp;
                    cuts += temp - 1;
                }
                if(req <= 0)
                    return cuts;
            }
        }
        for(int i=0; i<n; i++) {
            if(taken[i] == 1) continue;
            long temp = slices[i] / num;
            if(req - temp <= 0) {
                cuts += req;
                req = 0;
            } else {
                req -= temp;
                cuts += temp;
            }
            if(req <= 0)
                return cuts;
        }
        return -1; //stating impossible
    }
    
    void sortAndReverse(long[] a) {
        Arrays.sort(a);
        for(int i=0, j=a.length-1; i<j; i++, j--) {
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    
    long gcd(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
    
    // 1 5 2 10 5 359999999999 123456789 10
    
    //Reader & Writer
    String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    String nt() throws Exception {
        return nextToken();
    }

    String ns() throws Exception {
        return br.readLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nd() throws Exception {
        return Double.parseDouble(nextToken());
    }

    void p(Object o) {
        System.out.print(o);
    }

    void pl(Object o) {
        System.out.println(o);
    }
}