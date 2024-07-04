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
            int side = f.nextInt();
            int[][] mat = new int[side][side];
            long trace = 0;
            long r = 0;
            long c = 0;
            for (int i = 0; i < side; i++) {
            	boolean norepeats = true;
            	HashSet<Integer> hs = new HashSet<>();
            	for (int j = 0; j < side; j++) {
            		mat[i][j] = f.nextInt();
            		if (norepeats) {
            			if (hs.contains(mat[i][j])) {
            				norepeats = false;
                			r++;
            			} else {
            				hs.add(mat[i][j]);
            			}
            		}
            		if (i == j) trace += mat[i][j];
            	}
            }
            for (int i = 0; i < side; i++) {
            	boolean norepeats = true;
            	HashSet<Integer> hs = new HashSet<>();
            	for (int j = 0; j < side; j++) {
            		if (norepeats) {
            			if (hs.contains(mat[j][i])) {
            				norepeats = false;
                			c++;
            			} else {
            				hs.add(mat[j][i]);
            			}
            		}
            	}
            }
            System.out.printf("Case #%d: %d %d %d%n", asdf+1, trace, r, c);
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