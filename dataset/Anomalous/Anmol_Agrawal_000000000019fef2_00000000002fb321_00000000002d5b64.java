import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter w = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for (int tt = 1; tt <= t; tt++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            w.println("Case #" + tt + ": " + (r - 1) * (s - 1));
            
            for (int i = 1; i < r; i++) {
                for (int j = 1; j < s; j++) {
                    w.println((r - i) + " " + (r * s - r - j));
                }
            }
        }
        w.close();
    }
    
    static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }
        
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }
}