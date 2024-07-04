import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    boolean row[][], col[][];
    int n, sum, ans[][];
    
    boolean isValid(int u, int v) {
        if(u == v)  v++;
        if(v == n) {
            v = 0;  u++;
            if(u == n)  return true;
        }
        for(int i = 0; i < n; i++) {
            if(!row[u][i] && !col[v][i]) {
                row[u][i] = true;
                col[v][i] = true;
                ans[u][v] = i+1;
                if(isValid(u, v+1))  return true;
                row[u][i] = false;
                col[v][i] = false;
            }
        }
        return false;
    }
    
    boolean check(int ind, int s) {
        if(s > sum) return false;
        if(ind == n) {
            return s == sum && isValid(0, 0);
        }
        for(int i = 0; i < n; i++) {
            ans[ind][ind] = i+1;
            row[ind][i] = true;
            col[ind][i] = true;
            if(check(ind+1, s + i+1))    return true;
            row[ind][i] = false;
            col[ind][i] = false;
        }
        return false;
    }
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            n = ni();   sum = ni();
            row = new boolean[n][n];
            col = new boolean[n][n];
            ans = new int[n][n];
            if(check(0, 0)) {
                out.println("POSSIBLE");
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++)  out.print(ans[i][j] +" ");
                    out.println();
                }
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }
    
    long mp(long b, long e) {
        long r = 1;
        while(e > 0) {
            if( (e&1) == 1 )    r = (r * b) % mod;
            b = (b * b) % mod;
            e >>= 1;
        }
        return r;
    }
    
    // -------- I/O Template -------------
    
    char nc() {
        return ns().charAt(0);
    }
    
    String nLine() {
        try {
            return br.readLine();
        } catch(IOException e) {
            return "-1";
        }
    }
    
    double nd() {
        return Double.parseDouble(ns());
    }
    
    long nl() {
        return Long.parseLong(ns());
    }
    
    int ni() {
        return Integer.parseInt(ns());
    }
    
    StringTokenizer ip;
    
    String ns() {
        if(ip == null || !ip.hasMoreTokens()) {
            try {
                ip = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                throw new InputMismatchException();
            }
        }
        return ip.nextToken();
    }
    
    void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }
    
    public static void main(String[] args) {
        new Solution().run();
    }
}
