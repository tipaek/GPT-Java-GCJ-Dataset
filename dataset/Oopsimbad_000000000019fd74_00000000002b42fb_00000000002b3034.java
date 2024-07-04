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
			char[][] s = new char[n][];
			for(int i = 0; i < n; i++)
				s[i] = f.next().toCharArray();
			ArrayList<Character> pre = new ArrayList<>();
			ArrayList<Character> suf = new ArrayList<>();
			boolean works = true;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < s[i].length; j++)
					if(s[i][j] == '*') break;
					else if(j >= pre.size()) pre.add(s[i][j]);
					else works &= s[i][j] == pre.get(j);
				for(int j = 0; j < s[i].length; j++)
					if(s[i][s[i].length-j-1] == '*') break;
					else if(j >= suf.size()) suf.add(s[i][s[i].length-j-1]);
					else works &= s[i][s[i].length-j-1] == suf.get(j);
			}
			if(works) {
				for(char c : pre) out.print(c);
				for(int i = 0; i < n; i++) {
					int a = 0, b = s[i].length-1;
					while(a < s[i].length && s[i][a] != '*') a++;
					while(b >= 0 && s[i][b] != '*') b--;
					for(int j = a+1; j < b; j++) out.print(s[i][j]);
				}
				for(int i = suf.size()-1; i >= 0; i--) out.print(suf.get(i));
				out.println();
			} else out.println("*");			
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
