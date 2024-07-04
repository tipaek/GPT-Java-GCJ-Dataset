import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
    public void run() throws Exception {
        FastScanner f = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int nc = f.nextInt();
        for (int asdf = 0; asdf < nc; asdf++) {
           String s = f.nextLine();
           String ans = "";
           int prev = Integer.parseInt(s.substring(0,1));
           for (int i = 0; i < prev; i++) {
        	   ans += "(";
           }
           ans += prev;
           for (int i = 1; i < s.length(); i++) {
        	   int cur = Integer.parseInt(s.substring(i,i+1));
        	   if (cur > prev) {
        		   int diff = cur - prev;
        		   for (int j = 0; j < diff; j++) {
                	   ans += "(";
                   }
        	   } else if (cur < prev) {
        		   int diff = prev - cur;
        		   for (int j = 0; j < diff; j++) {
                	   ans += ")";
                   }
        	   }
        	   prev = cur;
        	   ans += cur;
           }
           for (int i = 0; i < prev; i++) {
        	   ans += ")";
           }
           System.out.printf("Case #%d: %s%n", asdf+1, ans);
        }
        out.flush();
    }
    
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
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
            try {
                return reader.readLine();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}