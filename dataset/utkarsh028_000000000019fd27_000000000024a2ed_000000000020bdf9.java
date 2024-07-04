import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    class pair {
        int S, E, I;
        pair(int s, int e, int i) {
            S = s;  E = e;  I = i;
        }
    }
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            int n = ni();
            pair a[] = new pair[n];
            for(int i = 0; i < n; i++)  a[i] = new pair(ni(), ni(), i);
            Arrays.sort(a, (pair u, pair v) -> (u.S - v.S));
            int e1 = -1, e2 = -1;
            char ans[] = new char[n];
            for(int i = 0; i < n; i++) {
                if(e1 <= a[i].S) {
                    ans[a[i].I] = 'C';   e1 = a[i].E;
                } else if(e2 <= a[i].S) {
                    ans[a[i].I] = 'J';   e2 = a[i].E;
                } else {
                    ans = null;     break;
                }
            }
            if(ans == null) out.println("IMPOSSIBLE");
            else    out.println(new String(ans));
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
