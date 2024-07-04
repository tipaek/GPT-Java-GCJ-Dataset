import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    class pair {
        int M, L;
        pair(int x, int y) {
            M = x;  L = y;
        }
    }
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            int n = ni(), d = ni();
            long a[] = new long[n];
            for(int i = 0; i < n; i++)  a[i] = nl();
            Arrays.sort(a);
            int cnt[] = new int[n];
            cnt[0] = 1;
            int max = 1;
            for(int i = 1; i < n; i++) {
                if(a[i] == a[i-1])  cnt[i] = cnt[i-1] + 1;
                else        cnt[i] = 1;
                max = Math.max(max, cnt[i]);
            }
            if(max >= d)    out.println(0);
            else {
                if(d == 2) {
                    out.println(1);
                } else {
                    HashSet <Double> h = new HashSet<>();
                    int ans = 2;
                    for(long x : a) {
                        if(h.contains(x / 2.0)) {
                            ans = 1;    break;
                        }
                        h.add(x * 1.0);
                    }
                    out.println(ans);
                }
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
