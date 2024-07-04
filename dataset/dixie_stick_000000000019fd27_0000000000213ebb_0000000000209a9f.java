import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;
public class Solution {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			
			String g = in.next();
			
			int N = g.length();
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = g.charAt(i) - '0';
			}
			
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < arr.length; i++) {
				int val = arr[i];
				
				for(int j = 0; j < val; j++) {
					
					if(stack.size() > 0 && stack.peek() == ')') {
						stack.pop();
					}
					else {
						stack.add('(');
					}
				}
				
				stack.add(g.charAt(i));
				
				for(int j = 0; j < val; j++) {
					stack.add(')');
				}
			}
			
			
			ArrayList<Character> list = new ArrayList<>(stack.size());
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
			
			
			sb.append("Case #" + (t+1) + ": ");
			for(int i = list.size() - 1; i >= 0; i--) {
				sb.append(list.get(i));
			}
			sb.append('\n');
		}
		
		System.out.println(sb);

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
4
0000
101
111000
1

  
Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)
*/