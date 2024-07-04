import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader()  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("p.txt"));
		}

		String next() {
			while(st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt()  {
			return Integer.parseInt(next());
		}
		long nextLong()  {
			return Long.parseLong(next());
		}
		double nextDouble()  {
			return Double.parseDouble(next());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st != null && st.hasMoreElements());
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t;
		t = fr.nextInt();
		String s1;
		char[] s;
		int np[],n;
		int d[];
		int current, next;
		StringBuilder result = new StringBuilder();
		for(int c = 1; c <= t; c++) {
			result = new StringBuilder();
			s1 = fr.next();	
			s1 = "0" + s1 + "0";
			n = s1.length();
			np = new int[n];
			s = s1.toCharArray();
			d = new int[n];
			for(int i = 0; i < n - 1; i++) {
				current = s[i] - 48;
				next = s[i+1] - 48;
				np[i] = current - next;
				d[i] = current;
			}
			for(int i = 0; i < n - 1; i++) {
				if (np[i] < 0) {
					for(int j = 0; j < Math.abs(np[i]); j++) {
						result.append("(");
					}
				} else {
					for(int j = 0; j < np[i]; j++) {
						result.append(")");
					}
				}
				if (i < n - 2)
					result.append(d[i+1]);
			}
			System.out.println("Case #"+c+": " +  result.toString());
		}

	}
}
