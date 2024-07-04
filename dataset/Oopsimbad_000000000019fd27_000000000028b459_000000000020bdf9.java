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
			out.printf("Case #%d: ", asdf);
			int n = f.nextInt();
			Thing[] t = new Thing[n];
			for(int i = 0; i < n; i++)
				t[i] = new Thing(i, f.nextInt(), f.nextInt());
			Arrays.sort(t);
			char[] ans = new char[n];
			boolean b = true;
			int c = 0, j = 0;
			for(int i = 0; i < n; i++) {
				if(c <= t[i].b) {
					ans[t[i].a] = 'C';
					c = t[i].c;
				} else if(j <= t[i].b) {
					ans[t[i].a] = 'J';
					j = t[i].c;
				} else b = false;
			}
			if(b) out.println(ans);
			else out.println("IMPOSSIBLE");
		}
///
		out.flush(); 
	}
	class Thing implements Comparable<Thing> {
		int a, b, c;
		public Thing(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public int compareTo(Thing t) {
			return Integer.compare(b, t.b);
		}
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
