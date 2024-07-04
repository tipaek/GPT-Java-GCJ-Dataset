import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    int u, v, n;
    int same, id;
    
    int query(int ind) {
        out.println(ind + 1);
        out.flush();
        return ni();
    }
    
    boolean checkRev(int a[]) {
        int l = 0, r = n-1;
        while(l < u-1 && r > v+1) {
            if(a[l] == a[l+1]) {
                if(a[r] != a[r-1]) {
                    same = a[l];    id = l;     return true;
                }
            } else {
                if(a[r] == a[r-1]) {
                    same = a[r];    id = r-1;   return true;
                }
            }
            l++;    r--;
        }
        return false;
    }
    
    void flipArray(int a[]) {
        for(int i = 0; i < u; i++)  a[i] = 1 - a[i];
        for(int i = v+1; i < n; i++)    a[i] = 1 - a[i];
    }
    
    void revArray(int a[]) {
        int l = 0, r = n-1;
        while(l < r) {
            int t = a[l];   a[l] = a[r];    a[r] = t;
            l++;    r--;
        }
        int t = u;  u = n-1 - v;    v = n-1 - u;
    }
    
    void solve() {
        int T = ni();   n = ni();
        for(int t = 1; t <= T; t++) {
            //out.print("Case #"+ t +": ");
            int a[] = new int[n];
            u = 0;  v = n-1;
            int p = 0;
            boolean canIdentifyRev = false;
            A: for(int i = 1; i <= 15; i++) {
                int q = 6;
                if(!canIdentifyRev)     canIdentifyRev = checkRev(a);
                if(canIdentifyRev) {
                    int x = query(id);      q--;
                    int y = query(id+1);      q--;
                    if(x != y) {
                        revArray(a);
                        id = n-2 - id;
                    }
                }
                // Check Flip
                if(i != 1) {
                    int x = query(0);   q--;
                    if(a[0] != x)       flipArray(a);
                }
                // Continue in both directions
                while(q-- > 0) {
                    if(p == 0) {
                        a[u] = query(u);    u++;
                    } else {
                        a[v] = query(v);    v--;
                    }
                    p = 1 - p;
                    if(u > v)   break A;
                }
            }
            for(int x : a)    out.print(x);
            out.println();      out.flush();
            char result = nc();
            if(result == 'N')   break;
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
