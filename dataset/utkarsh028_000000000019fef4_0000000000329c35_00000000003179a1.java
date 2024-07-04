import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7), inf = (long) (3e18);
    
    class pair {
        int M;  char S[];
        pair(int m, String s) {
            M = m;  S = s.toCharArray();
        }
    }
    
    class pr {
        char C;
        HashSet <Integer> H;
        pr(char c, HashSet<Integer> h) {
            C = c;  H = h;
        }
    }
    
    char ans[];
    pr dp[];
    pair a[];
    int n;
    HashMap <Character, Integer> digg;
    boolean vst[];
    
    long convert(char s[]) {
        long ans = 0;
        for(char c : s) {
            ans = ans * 10 + digg.get(c);
        }
        return ans;
    }
    
    boolean play(int x) {
        if(x == 10) {
            for(int i = 0; i < n; i++)  if(convert(a[i].S) > a[i].M)   return false;
            for(char c: digg.keySet())  ans[digg.get(c)] = c;
            return true;
        }
        char c = dp[x].C;
        for(int i = 0; i < 10; i++) {
            if(!vst[i] && dp[x].H.contains(i)) {
                digg.put(c, i);
                vst[i] = true;
                if (play(x+1))  return true;
                vst[i] = false;
            }
        }
        return false;
    }
    
    void solve() {
        int T = ni();
        for(int t = 1; t <= T; t++) {
            out.print("Case #"+ t +": ");
            int digits = ni();
            n = 10000;
            a = new pair[n];
            HashMap <Character, HashSet<Integer>> mp = new HashMap<>();
            for(int i = 0; i < n; i++) {
                a[i] = new pair(ni(), ns());
                for(char c : a[i].S) {
                    if(mp.containsKey(c))   continue;
                    HashSet <Integer> h = new HashSet<>();
                    for(int j = 0; j < 10; j++) h.add(j);
                    mp.put(c, h);
                }
            }
            Arrays.sort(a, (pair u, pair v) -> (u.M - v.M));
            ans = new char[10];
            
                for(int i = 0; i < n; i++) {
                    String str = ("" + a[i].M);
                    if(str.length() > a[i].S.length)  continue;
                    
                    int dig = str.charAt(0) - '0';
                    char c = a[i].S[0];
                    HashSet <Integer> h = mp.get(c);
                    
                    for(int j = dig+1; j < 10; j++) {
                        if(h.contains(j))   h.remove(j);
                    }
                    mp.put(c, h);
                }
                
                dp = new pr[10];   int z = 0;
                for(char c : mp.keySet()) {
                    dp[z++] = new pr(c, mp.get(c));
                }
            digg = new HashMap<>();
            vst = new boolean[10];
            play(0);
                
            out.println(new String(ans));
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
