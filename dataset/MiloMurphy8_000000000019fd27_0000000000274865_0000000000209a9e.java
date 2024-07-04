//package codejam.qual;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        while (t-- > 0)
            solve();
    }
 
    public static void solve() {
        
        int b = in.nextInt();
        StringBuilder res = new StringBuilder();
        int a[] = new int[b];
        Arrays.fill(a, -1);
        int j = 1;
        for(int i = 1; i <= 150; ++i){
            
            if((i - 1) % 10 == 1){
                System.out.println(j - 1);
            }else{
                System.out.println(j);
            }
            int response = in.nextInt();
            a[j] = response;
            if(j >= b){
                j = 1;
            }
            j++;
        }
        for(int i = 0; i < b; ++i)
            res.append(a[i]);
        
        System.out.println(res);
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
