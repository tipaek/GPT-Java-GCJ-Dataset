import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    int[] bits(long n) {
        int z = 32;
        int a[] = new int[z];
        for(int i = 0; i < z; i++)  a[i] = (int)((n >> i) & 1);
        return a;
    }
    
    int check(int a[], int b[]) {
        int z = 32;
        for(int i = 0; i < z; i++) {
            if(a[i] == 1 && b[i] == 1)  return -1;
            if(a[i] == 0 && b[i] == 0) {
                for(int j = i+1; j < z; j++) {
                    if(a[j] == 1 || b[j] == 1)  return -1;
                }
                return i;
            }
        }
        return z;
    }
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            int x = ni(), y = ni();
            if(x % 2 == y % 2) {
                out.println("IMPOSSIBLE");  continue;
            }
            int xsign = 1, ysign = 1;
            if(x < 0) {
                x = -x; xsign = -1;
            }
            if(y < 0) {
                y = -y; ysign = -1;
            }
            long x2p = 1;
            while(x2p <= x) x2p <<= 1;
            long y2p = 1;
            while(y2p <= y) y2p <<= 1;
            
            int a[][] = new int[][]{bits(x), bits(x2p - x + x2p)};
            int b[][] = new int[][]{bits(y), bits(y2p - y + y2p)};
            int sz = -1;
            char ans[] = new char[32];
            
            sz = check(a[0], b[0]);
            if(sz != -1) {
                for(int i = 0; i < sz; i++) {
                    if(a[0][i] == 1)    out.print(xsign == 1 ? 'E' : 'W');
                    else                out.print(ysign == 1 ? 'N' : 'S');
                }
                out.println();
                continue;
            }
            sz = check(a[0], b[1]);
            if(sz != -1) {
                for(int i = 0; i < sz; i++) {
                    if(a[0][i] == 1)    out.print(xsign == 1 ? 'E' : 'W');
                    else {
                        if((1L << i) != y2p)    out.print(ysign == 1 ? 'S' : 'N');
                        else                    out.print(ysign == 1 ? 'N' : 'S');
                    }
                }
                out.println();
                continue;
            }
            sz = check(a[1], b[0]);
            if(sz != -1) {
                for(int i = 0; i < sz; i++) {
                    if(a[1][i] == 1) {
                        if((1L << i) != x2p)    out.print(xsign == 1 ? 'W' : 'E');
                        else                    out.print(xsign == 1 ? 'E' : 'W');
                    }
                    else                out.print(ysign == 1 ? 'N' : 'S');
                }
                out.println();
                continue;
            }
            sz = check(a[1], b[1]);
            if(sz != -1) {
                for(int i = 0; i < sz; i++) {
                    if(a[1][i] == 1) {
                        if((1L << i) != x2p)    out.print(xsign == 1 ? 'W' : 'E');
                        else                    out.print(xsign == 1 ? 'E' : 'W');
                    } else {
                        if((1L << i) != y2p)    out.print(ysign == 1 ? 'S' : 'N');
                        else                    out.print(ysign == 1 ? 'N' : 'S');
                    }
                }
                out.println();
                continue;
            }
            out.println("IMPOSSIBLE");
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
