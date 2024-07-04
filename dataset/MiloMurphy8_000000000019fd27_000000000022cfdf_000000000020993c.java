//package codejam.qual;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Milo
 */
 
 //Vestigium
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
        for(int i = 1; i <= t; ++i){
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }
 
    public static void solve() {
        
        int n = in.nextInt();
        int k = 0, r = 0, c = 0;
        
        int a[][] = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                a[i][j] = in.nextInt();
                if(i == j){
                    k += a[i][j];
                }
            }
        }
        HashSet<Integer> hs = new HashSet();
        //row repitition
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                hs.add(a[i][j]);
            }
            if(hs.size() != n) ++r;
            hs.clear();
        }
        
        //col repitition
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                hs.add(a[j][i]);
            }
            if(hs.size() != n) ++c;
            hs.clear();
        }
        
        
        System.out.printf("%d %d %d\n", k, r, c);
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
