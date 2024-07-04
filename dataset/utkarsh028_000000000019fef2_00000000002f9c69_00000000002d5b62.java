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
            long x = nl(), y = nl();
            char ans[] = new char[35];
            char r = 'E';
            if(x < 0) {
                x = -x; r = 'W';
            }
            int z = 0;
            for(int i = 0; i < 32; i++) {
                if(((x >> i) & 1) > 0) {
                    ans[i] = r;
                    z = i;
                }
            }
            boolean found = false;
            long yy = y;
            for(int i = z; i < 32; i++) {
                y = yy;
                for(int j = i; j >= 0; j--) {
                    if(ans[j] != r) {
                        if(y > 0) {
                            ans[j] = 'N';   y -= (1L << j);
                        } else {
                            ans[j] = 'S';   y += (1L << j);
                        }
                    }
                }
                if(y == 0) {
                    found = true;   z = i;  break;
                }
            }
            
            if(!found)  out.println("IMPOSSIBLE");
            else {
                for(int i = 0; i <= z; i++) out.print(ans[i]);
                out.println();
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
