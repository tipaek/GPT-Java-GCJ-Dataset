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
            int n = ni(), k = ni();
            //int n = 5, k = 16;
            int[] a = new int[n];
            int sum = k - n;
            Arrays.fill(a, 1);
            for(int i=0; i<n; i++) {
                while(a[i] < n && sum != 0) {
                    a[i]++; sum--;
                }
            }
            
            List<Triple> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    for(int z=1; z<=n; z++) {
                        list.add(new Triple(i, j, z));
                    }
                }
            }
            
            boolean found = false;
            while(true) {
                for(int i=0; i<list.size(); i++) {
                    int[][] work = new int[n][n];
                    for(int z=0; z<n; z++) work[z][z] = a[z];
                    for(int j=i; j<list.size(); j++) {
                        if(ok(list.get(j), work)) {
                            work[list.get(j).a][list.get(j).b] = list.get(j).c;
                        }
                    }
                    if(isFilled(work)) {
                        StringBuilder res = new StringBuilder(10000);
                        res.append("POSSIBLE\n");
                        for(int x=0; x<n; x++) {
                            for(int y=0; y<n; y++) {
                                res.append(work[x][y] + " ");
                            }
                            res.deleteCharAt(res.length() - 1).append("\n");
                        }
                        p(res);
                        found = true;
                        break;
                    }
                }
                
                if(found) break;
                
                if(!formsNext(a)) break;
            }
            
            if(!found) pl("IMPOSSIBLE");
        }
    }
    
    boolean isFilled(int[][] a) {
        int n = a.length;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(a[i][j] == 0) return false;
        return true;
    }
    
    boolean ok(Triple t, int[][] a) {
        if(a[t.a][t.b] > 0) return false;
        int val = t.c, n = a.length;
        for(int i=0; i<n; i++) {
            if(a[t.a][i] == val) return false;
            if(a[i][t.b] == val) return false;
        }
        return true;
    }
    
    boolean formsNext(int[] a) {
        int n = a.length;
        for(int i=n-1; i>0; i--) {
            if(a[i] < a[i-1]) {
                a[i-1]--; a[i]++;
                return true;
            }
        }
        return false;
    }
    
    class Triple {
        int a, b, c;
        public Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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