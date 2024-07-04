//package codejam.qual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Milo
 */
public class Solution {

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
        int s = (24 * 60) + 1;
        StringBuilder res = new StringBuilder();
        int SC[] = new int[s];
        int SJ[] = new int[s];

        for (int i = 0; i < n; ++i) {
            int st = in.nextInt();
            int ed = in.nextInt();
            int f = 0;
            
            if(!contain(SC, st, ed)){
                for(int j = st; j < ed; ++j){
                    SC[j] = 1;
                }
                res.append('C');
                f = 1;
            }
            if(f == 1) continue;
            
            if(!contain(SJ, st, ed)){
                for(int j = st; j < ed; ++j){
                    SJ[j] = 1;
                }
                res.append('J');
            }

        }
        if (res.length() != n) {
            System.out.print("IMPOSSIBLE\n");
        } else {
            System.out.print(res + "\n");
        }
    }
    
    public static boolean contain(int[] a, int s, int e){
        for(int i = s; i < e; ++i){
            if(a[i] == 1) return true;
        }
        return false;
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
}