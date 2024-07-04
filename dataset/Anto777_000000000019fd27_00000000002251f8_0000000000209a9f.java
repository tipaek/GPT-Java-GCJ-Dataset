//package solution;

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
import java.awt.Point;

public final class Solution {
    BufferedReader br;
    StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch(Exception ex) {ex.printStackTrace();}
            }
        }, "solution", 1<<26).start();
    }
    
    {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    long mod = 1000000007L;
    void run() throws Exception {
        int t = ni();
        for(int I=1; I<=t; I++) {
            String s = nt();
            StringBuilder str = new StringBuilder(1000);
            for(int i=0; i<s.length(); i++) {
                int num = s.charAt(i) - '0', frq = num;
                String temp = "" + num;
                while(frq-- > 0) {
                    temp = "(" + temp + ")";
                }
                str.append(temp);
            }
            String res = str.toString();
            while(res.contains(")(")) {
                res = res.replace(")(", "");
            }
            
            pl("Case #" + I + ": " + res);
        }
    }
    
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