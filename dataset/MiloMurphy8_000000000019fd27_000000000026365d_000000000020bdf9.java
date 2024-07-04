//package codejam.qual;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Milo
 */
public class Solution{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static FastReader in = new FastReader();
    public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }
 
    public static void solve() {
        
        int n = in.nextInt();
        
        int si = 24 * 60 + 1;
        int sc[] = new int[si];
        int sj[] = new int[si];
        StringBuilder res = new StringBuilder();
        Map<Pair, Character> mp = new TreeMap<Pair, Character>((t, t1) -> {
            return t.st - t1.st;
        });
        
        Map<Pair, Character> seq = new LinkedHashMap();
        for(int i = 0; i < n; ++i){
            int s = in.nextInt();
            int e = in.nextInt();
            mp.put(new Pair(s, e), 'N');
            seq.put(new Pair(s, e), 'N');
        }
        
        int j = 0;
        Pair prev = null;
        char p = 'N';
        for (Map.Entry<Pair, Character> e : mp.entrySet()) {
            Pair key = e.getKey();
            if(j == 0){
                j = 1;
                prev = key;
                p = 'C';
                mp.replace(key, p);
                continue;
            }
            if(sc[key.st] == 1 || sc[key.ed - 1] == 1) continue;
            if(sj[key.st] == 1 || sj[key.ed - 1] == 1) continue;
            if(key.st < prev.ed){
                
                if(p == 'J'){
                    mp.replace(key, 'C');
                    sc[key.st] = sc[key.ed - 1] = 1;
                }
                else if (p == 'C'){
                    mp.replace(key, 'J');
                    sj[key.st] = sj[key.ed - 1] = 1;
                }
            }else{
                mp.replace(key, p);
            }
            
            prev = key;
            p = mp.get(key);
        }
        
        for (Map.Entry<Pair, Character> entry : seq.entrySet()) {
            Pair key = entry.getKey();
            if(mp.get(key) == 'N') continue;
            res.append(mp.get(key));
            
        }
        if(res.length() != n){
            System.out.print("IMPOSSIBLE\n");
            return;
        }
        System.out.print(res + "\n");
    }
 
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
 
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
 
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, (a % b));
    }

    private static class Pair{
        int st, ed;
        public Pair(int a, int b) {
            st = a;
            ed = b;
        }

        @Override
        public String toString() {
            return "(" +st + "-" + ed +")";
        }
        
        
    }
}
