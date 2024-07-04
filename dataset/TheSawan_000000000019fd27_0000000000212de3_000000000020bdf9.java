import java.io.*;
import java.util.*;

public class Solution{
	static LinkedList<Integer>[]adj;
	static int[]col;
	static boolean yes;
	static void dfs(int i) {
		for(int j:adj[i]) {
			if(col[j]==-1) {
				col[j]=1-col[i];
				dfs(j);
			}
			else {
				if(col[i]==col[j]) {
					yes=false;
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			int n=sc.nextInt();
			int[][]events=new int[2*n][];
			for(int i=0;i<n;i++) {
				events[i<<1]=new int[] {0,sc.nextInt(),i};
				events[i<<1|1]=new int[] {1,sc.nextInt(),i};
			}
			Arrays.sort(events,(x,y)->x[1]==y[1]?y[0]-x[0]:x[1]-y[1]);
			adj=new LinkedList[n];
			for(int i=0;i<n;i++)adj[i]=new LinkedList<>();
			
			TreeSet<Integer>exist=new TreeSet<>();
			for(int[]e:events) {
				if(e[0]==0) {
					int i=e[2];
					for(int j:exist) {
						adj[i].add(j);
						adj[j].add(i);
					}
					exist.add(i);
					
				}
				else {
					exist.remove(e[2]);
					
				}
			}
			yes=true;
			col=new int[n];
			Arrays.fill(col, -1);
			for(int i=0;i<n;i++) {
				if(col[i]==-1) {
					col[i]=0;
					dfs(i);
				}
			}
			pw.print("Case #"+test+": ");
			if(!yes) {
				pw.println("IMPOSSIBLE");
				continue;
			}
			for(int i=0;i<n;i++) {
				pw.print(col[i]==0?'C':'J');
			}
			pw.println();
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