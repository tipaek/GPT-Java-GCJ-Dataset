import java.io.*;
import java.util.*;

public class Solution{
	static int query(MScanner sc,PrintWriter pw,int bit) throws IOException {
		pw.println(bit);
		pw.flush();
		return sc.nextInt();
	}
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt(),b=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			int[]ans=new int[b+1];
			
			int known=0;
			while(known<b/2) {
				boolean[]ok=new boolean[b+1];
				int q=10;
				for(int i=1;i<=known;i++) {
					if(ok[i])continue;
					int cur=query(sc, pw, i);
					q--;
					int relation=ans[i]^ans[b-i+1];
					int difference=ans[i]^cur;
					for(int j=i+1;j<=known;j++) {
						int curRel=ans[j]^ans[b-j+1];
						if(relation==curRel) {
							ok[j]=true;
							ans[j]^=difference;
							ans[b-j+1]^=difference;
						}
					}
					
					ans[i]=cur;
					ans[b-i+1]^=difference;
				}
				while(q>=2 && known<b/2) {
					int bit=++known;
					ans[bit]=query(sc, pw, bit);
					ans[b-bit+1]=query(sc, pw, b-bit+1);
					q-=2;
				}
				while(q>0) {
					query(sc, pw, 1);q--;
				}
			}
			for(int bit=1;bit<=b;bit++)pw.print(ans[bit]);
			pw.println();
			pw.flush();
			char ok=sc.nextChar();
			if(ok=='N')break;
		}
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