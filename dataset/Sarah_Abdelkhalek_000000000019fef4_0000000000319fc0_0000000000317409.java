import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int caseNum = 1;
		int t = sc.nextInt();
		out: while (t-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			char arr[] = sc.next().toCharArray();
			
			
			int t1 = 0;
			
			for(int i=0;i<arr.length;i++) {
				t1++;
				if(arr[i]=='W')x--;
				else if(arr[i]=='E')x++;
				else if(arr[i]=='N')y++;
				else if(arr[i]=='S')y--;
				if(Math.abs(x)+Math.abs(y)<=t1) {
					System.out.printf("Case #%d: %d\n",caseNum++,t1);
					continue out;
				}
			}
			System.out.printf("Case #%d: %s\n",caseNum++,"IMPOSSIBLE");


		}

	}
}

class Scanner {
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
