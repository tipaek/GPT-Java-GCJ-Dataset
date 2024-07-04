import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
	static BufferedWriter bufferedWriter;
	static String yes = "YES";
	static String no = "NO";
	
	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
		int tp = sc.nextInt();
		for (int i_t = 0; i_t < tp; i_t++) {
			
			String s= sc.next();
			int n = s.length();
			String ans = solve(s,n);
			bufferedWriter.write("Case #"+(i_t+1)+": " + ans + "\n");
		}
		bufferedWriter.flush();

	}

	private static String solve(String s, int n) {
		int prev=0;
		String ans="";
		int x=0;
		for(int i=0;i<n;i++) {
			x=s.charAt(i)-'0';
			int diff=x-prev;prev=x;
			ans+= diff>0?getOpen(diff):getClose(Math.abs(diff));
			ans+=x;
		}
		return ans+getClose(x);
	}

	private static String getClose(int diff) {
		String ans="";
		for(int i=0;i<diff;i++)
			ans+=")";
		return ans;
	}

	private static String getOpen(int diff) {
		String ans="";
		for(int i=0;i<diff;i++)
			ans+="(";
		return ans;
	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br=new  BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
