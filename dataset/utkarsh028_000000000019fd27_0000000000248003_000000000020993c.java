import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            int n = ni();
            long d = 0;
            long a[][] = new long[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)  a[i][j] = nl();
                d += a[i][i];
            }
            HashSet <Long> h = new HashSet<>();
            
            long r = 0;
            for(int i = 0; i < n; i++) {
                h.clear();
                for(int j = 0; j < n; j++) {
                    if(!h.add(a[i][j])) {
                        r++;    break;
                    }
                }
            }
            
            long c = 0;
            for(int j = 0; j < n; j++) {
                h.clear();
                for(int i = 0; i < n; i++) {
                    if(!h.add(a[i][j])) {
                        c++;    break;
                    }
                }
            }
            out.println(d +" "+ r +" "+ c);
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
