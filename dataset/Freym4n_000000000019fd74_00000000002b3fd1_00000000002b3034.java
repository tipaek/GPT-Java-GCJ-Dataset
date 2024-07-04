import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		int n,len,idx;
		String s[],longer;
		for(int c = 1; c <= t; c++) {
			n = fr.nextInt();
			s = new String[n];
			len = 0;
			idx = 0;
			for(int i = 0; i < n; i++) {
				s[i] = fr.next().replace("*", "");
				if (s[i].length() > len) {
					len = s[i].length();
					idx = i;
				}
			}
			longer = s[idx];
			boolean posible = true;
			for(int i = 0; i < n && posible; i++) {
				if (i == idx) continue;
				if (!longer.contains(s[i])) {
					posible = false;
				}
			}
			
			System.out.print("Case #"+c+": ");
			if (posible) System.out.println(longer);
			else System.out.println("*");
		}
	}
	
	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader() throws FileNotFoundException  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("input.txt"));
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
}
