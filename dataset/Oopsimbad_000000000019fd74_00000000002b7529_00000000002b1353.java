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
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d:%n", asdf);
			int n = f.nextInt();
			boolean found = false;
			for(int rows = 1; !found && rows < 500; rows++) {
				for(int use = 0; !found && use <= rows; use++) {
					if(Integer.bitCount(n-(rows-use)) == use && Integer.highestOneBit(n-(rows-use)) <= 1 << (rows-1)) {
						boolean right = false;
						n = n-(rows-use);
						for(int i = 0; i < rows; i++) {
							if((n & (1 << i)) != 0) {
								if(!right) {
									for(int j = 0; j <= i; j++)
										out.printf("%d %d%n", i+1, j+1);
								} else {
									for(int j = 0; j <= i; j++)
										out.printf("%d %d%n", i+1, i-j+1);
								}
								right ^= true;
							} else if(right) out.printf("%d %d%n", i+1, i+1);
							else out.printf("%d %d%n", i+1, 1);
						}
						found = true;	
					}
				}
			}
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
