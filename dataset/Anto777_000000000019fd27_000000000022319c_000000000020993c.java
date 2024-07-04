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
            int n = ni();
            int[][] a = new int[n][n];
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    a[i][j] = ni();
            
            int rowReps = 0, colReps = 0, trace = 0;
            for(int i=0; i<n; i++) {
                HashMap<Integer, Integer> map;
                map = new HashMap<>();
                for(int j=0; j<n; j++) {
                    int num = a[i][j];
                    if(map.containsKey(num)) {
                        rowReps++;
                        break;
                    } else {
                        map.put(num, 1);
                    }
                }
                map = new HashMap<>();
                for(int j=0; j<n; j++) {
                    int num = a[j][i];
                    if(map.containsKey(num)) {
                        colReps++;
                        break;
                    } else {
                        map.put(num, 1);
                    }
                }
                trace += a[i][i];
            }
            
            pl("Case #" + I + ": " + trace + " " + rowReps + " " + colReps);
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