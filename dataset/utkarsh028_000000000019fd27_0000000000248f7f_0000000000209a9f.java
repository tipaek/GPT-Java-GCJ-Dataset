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
            char s[] = ns().toCharArray();
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : s) {
                while(cnt < (c - '0')) {
                    sb.append('(');     cnt++;
                }
                while(cnt > (c - '0')) {
                    sb.append(')');     cnt--;
                }
                sb.append(c);
            }
            while(cnt > 0) {
                sb.append(')');     cnt--;
            }
            out.println(sb.toString());
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
