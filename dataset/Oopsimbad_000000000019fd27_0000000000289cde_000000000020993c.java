import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Vestigium {
	public static void main(String[] args) throws Exception {
		new Vestigium().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			int[][] mat = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j  <n; j++) mat[i][j] = f.nextInt();
			int a = 0, b = 0, c = 0;
			for(int i = 0; i < n; i++) {
				a += mat[i][i];
				boolean[] b1 = new boolean[n], b2 = new boolean[n];
				boolean B1 = false, B2 = false;
				for(int j = 0; j < n; j++) {
					if(b1[mat[i][j]-1]) B1 = true;
					else b1[mat[i][j]-1] = true;
					if(b2[mat[j][i]-1]) B2 = true;
					else b2[mat[j][i]-1] = true;
				}
				if(B1) b++;
				if(B2) c++;
			}
			out.printf("Case #%d: %d %d %d%n", asdf, a, b, c);
		}
///
		out.flush(); 
	}
///
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
