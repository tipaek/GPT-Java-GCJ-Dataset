import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Solution {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			int N = in.nextInt();
			String[] pats = new String[N];
			for(int i = 0; i < N; i++) {
				pats[i] = in.next();	
			}
			
			boolean valid = true;
			char[] cs = new char[9999];
			Arrays.fill(cs, '?');
			
			int index = 0;
			
			for(String pat : pats) {
				String[] rest = getSplit(pat);
				//System.out.println("rest = " + Arrays.toString(rest));
				if(rest[0].length() > 0) {
					for(int j = 0; j < rest[0].length(); j++) {
						if(cs[j] != '?' && rest[0].charAt(j) != cs[j]) {
							valid = false;
							//System.out.println("huh j = " + j + " pat = " + pat);
							break;
						}
						cs[j] = rest[0].charAt(j);
					}
					index = Math.max(rest[0].length(), index);
				}
				
				if(!valid) break;
				
				if(rest[rest.length-1].length() > 0) {
					String last = rest[rest.length-1];
					for(int j = 0; j < last.length(); j++) {
						if(cs[cs.length-1-j] != '?' && last.charAt(last.length()-1-j) != cs[cs.length-1-j]) {
							valid = false;
							//System.out.println("what j = " + j + " pat = " + pat);
							//System.out.println("original = " + cs[cs.length-1-j] + " trying to be replaced by " + );
							break;
						}
						cs[cs.length-1-j] = last.charAt(last.length()-1-j);
					}
				}
				
				if(!valid) break;
				
				for(int i = 1; i < rest.length-1; i++) {
					index++;
					String word = rest[i];
					
					for(int j = 0; j < word.length(); j++) {
						cs[index++] = word.charAt(j);
					}
					
				}
			}
			
			sb.append("Case #" + (1+t) + ": ");
			if(!valid) {
				sb.append("*\n");
			}
			else {
				for(char c : cs) {
					if(c != '?') {
						sb.append(c);
					}
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	public static String[] getSplit(String g) {
		ArrayList<String> list = new ArrayList<>();
		
		int i = 0;
		
		while(i < g.length()) {
			/*
			while(i < g.length() && g.charAt(i) == '*') {
				i++;
			}
			*/
			int prev = i;
			int j = i;
			while(j < g.length() && g.charAt(j) != '*') {
				j++;
			}
			
			list.add(g.substring(i, j));
			i = j;
			if(i == prev) {
				i = prev+1;
			}
		}
		
		String[] ans = new String[list.size()];
		for(i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		
		return ans;
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}
/*
2
5
*CONUTS
*COCONUTS
*OCONUTS
*CONUTS
*S
2
*XZ
*XYZ

  
Case #1: COCONUTS
Case #2: *

1
4
H*O
HELLO*
*HELLO
HE*

HELLO

1
2
CO*DE
J*AM

Case #1: *

1
2
CODE*
*JAM

Case #1: CODEJAM

1
2
A*C*E
*B*D*

Case #1: ABCDE


1
2
A*C*E
*B*D

Case #1: *

1
2
**Q**
*A*

Case #1: AQ
*/