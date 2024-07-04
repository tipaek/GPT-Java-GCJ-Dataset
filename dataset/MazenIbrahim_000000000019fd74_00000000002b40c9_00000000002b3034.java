import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int k=1;
	all:	while(t-->0) {
			int n=sc.nextInt();
			string [] s= new string[n];
			for(int i=0;i<n;i++) {
				s[i]=new string(sc.nextLine());
			}
			Arrays.sort(s);
			for(int i=0;i<s.length-1;i++) {
				if(!s[i+1].s.contains(s[i].s.substring(1))) {
					System.out.printf("Case #%d: *\n",k++);
					continue all;
				}
			}
			System.out.printf("Case #%d: %s\n",k++,s[n-1].s.substring(1));
		}
	}
	static class string implements Comparable<string>{
		String s;
		string(String k){
			s=k;
		}
		@Override
		public int compareTo(string o) {
			return this.s.length()-o.s.length();
		}
		
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
