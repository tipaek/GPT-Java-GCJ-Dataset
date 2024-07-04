import java.io.*;
import java.util.*;

public class Solution{
	static int[][]ans;
	static int n,k;
	
	static int[][]cloneArr(int[][]in){
		int[][]res=new int[n][];
		for(int i=0;i<n;i++) {
			res[i]=in[i].clone();
		}
		return res;
	}
	
	static void solve(int i,int j,int[][]grid) {
		if(ans!=null)return;
		if(i>=n) {
			int sum=0;
			for(int o=0;o<n;o++)sum+=grid[o][o];
			if(sum==k) {
				ans=cloneArr(grid);
			}
			return;
		}
		HashSet<Integer>nums=new HashSet<Integer>();
		for(int o=1;o<=n;o++)nums.add(o);
		for(int k=0;k<i;k++) {
			nums.remove(grid[k][j]);
		}
		for(int k=0;k<j;k++) {
			nums.remove(grid[i][k]);
		}
		
		for(int x:nums) {
			int[][]tmp=cloneArr(grid);
			tmp[i][j]=x;
			if(j<n-1)
				solve(i, j+1, tmp);
			else {
				solve(i+1, 0, tmp);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			ans=null;
			n=sc.nextInt();k=sc.nextInt();
			solve(0, 0, new int[n][n]);
			
			pw.print("Case #"+test+": ");
			if(ans==null) {
				pw.println("IMPOSSIBLE");
			}
			else {
				pw.println("POSSIBLE");
				for(int i=0;i<n;i++) {
					for(int j=0;j<n-1;j++) {
						pw.print(ans[i][j]+" ");
					}
					pw.println(ans[i][n-1]);
				}
			}
		}
		pw.flush();
	}
	static class MScanner {
		StringTokenizer st;
		BufferedReader br;
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int[] intArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public long[] longArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public int[] intSortedArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public long[] longSortedArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		static void shuffle(int[]in) {
			for(int i=0;i<in.length;i++) {
				int idx=(int)(Math.random()*in.length);
				int tmp=in[i];
				in[i]=in[idx];
				in[idx]=tmp;
			}
		}
		static void shuffle(long[]in) {
			for(int i=0;i<in.length;i++) {
				int idx=(int)(Math.random()*in.length);
				long tmp=in[i];
				in[i]=in[idx];
				in[idx]=tmp;
			}
		}
		public Integer[] IntegerArr(int n) throws IOException {
	        Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public Long[] LongArr(int n) throws IOException {
	        Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public char nextChar() throws IOException {
			return next().charAt(0);
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
	static void addX(int[]in,int x) {
		for(int i=0;i<in.length;i++)in[i]+=x;
	}
	static void addX(long[]in,int x) {
		for(int i=0;i<in.length;i++)in[i]+=x;
	}
}