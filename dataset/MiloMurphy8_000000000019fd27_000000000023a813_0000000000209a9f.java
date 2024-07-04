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
        for(int i = 1; i <= t; ++i){
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }
 
    public static void solve() {
        
        String s = in.next();
        int l = s.length();
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < l; ++i){
            if(s.charAt(i) == '1'){
                if(res.length() == 0 || res.charAt(res.length() - 1) == '0'){
                    res.append('(').append(s.charAt(i));
                }else{
                    res.append(s.charAt(i));
                }
                if(i == l - 1){
                    res.append(')');
                }
            }else if(s.charAt(i) == '0'){
                if(res.length() > 0 && res.charAt(res.length() - 1) == '1'){
                    res.append(')').append(s.charAt(i));
                }else{
                    res.append(s.charAt(i));
                }
            }
            
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
}
