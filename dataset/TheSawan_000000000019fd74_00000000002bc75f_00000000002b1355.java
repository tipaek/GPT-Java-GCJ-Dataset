import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int n=sc.nextInt(),m=sc.nextInt();
			int[][]in=new int[n][m];
			long sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					sum+=(in[i][j]=sc.nextInt());
				}
			}
			long ans=0;
			while(true) {
				long prev=sum;
				sum=0;
				int[][]newin=new int[n][m];
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						long s=0,cnt=0;
						for(int k=i+1;k<n;k++) {
							if(in[k][j]!=0) {
								s+=in[k][j];
								cnt++;
								break;
							}
						}
						for(int k=i-1;k>=0;k--) {
							if(in[k][j]!=0) {
								s+=in[k][j];
								cnt++;
								break;
							}
						}
						for(int k=j+1;k<m;k++) {
							if(in[i][k]!=0) {
								s+=in[i][k];
								cnt++;
								break;
							}
						}
						for(int k=j-1;k>=0;k--) {
							if(in[i][k]!=0) {
								s+=in[i][k];
								cnt++;
								break;
							}
						}
						
						if(s>in[i][j]*cnt) {
							newin[i][j]=0;
							
						}
						else {
							newin[i][j]=in[i][j];
							sum+=in[i][j];
						}
					}
				}
				ans+=prev;
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						in[i][j]=newin[i][j];
					}
				}
				if(sum==prev) {
					break;
				}
			}
			
			
			pw.println(ans);
			
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