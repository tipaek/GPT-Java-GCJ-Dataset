import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
	static BufferedWriter bufferedWriter;
	
	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
		int tp = sc.nextInt();
		for (int i_t = 0; i_t < tp; i_t++) {
		
			int n = sc.nextInt();
			
			int[][] mt = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					mt[i][j]=sc.nextInt();
			bufferedWriter.write("Case #"+(i_t+1)+": ");
			solve(mt,n);
		}
		bufferedWriter.flush();

	}

	private static void solve(int[][] mt, int n) throws IOException {
		long ans = 0;
		for(int i=0;i<n;i++) {
			ans+=mt[i][i];
		}
		bufferedWriter.write(ans+" ");
		bufferedWriter.write(rowsNotHavingUniqueElements(mt,n)+" ");
		bufferedWriter.write(columnsNotHavingUniqueElements(mt,n)+" \n");
	}

	private static String rowsNotHavingUniqueElements(int[][] mt, int n) {
		int ans=0;
		for(int i=0;i<n;i++) {
			int[] dp=new int[n];
			for(int j=0;j<n;j++) {
				if(mt[i][j]<1||mt[i][j]>n||dp[mt[i][j]-1]==1) {
					ans++;break;
				}
				dp[mt[i][j]-1]=1;
			}
		}
		return Integer.toString(ans);
	}

	private static String columnsNotHavingUniqueElements(int[][] mt, int n) {
		int ans=0;
		for(int j=0;j<n;j++) {
			int[] dp=new int[n];
			for(int i=0;i<n;i++) {
				if(mt[i][j]<1||mt[i][j]>n||dp[mt[i][j]-1]==1) {
					ans++;break;
				}
				dp[mt[i][j]-1]=1;
			}
		}
		return Integer.toString(ans);
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
