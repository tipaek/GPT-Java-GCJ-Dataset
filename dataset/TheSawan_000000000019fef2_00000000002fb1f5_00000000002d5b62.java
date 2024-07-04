import java.io.*;
import java.util.*;

public class Solution{
	static boolean check(int[]bits,int []other) {
		boolean zeros=false;
		for(int i=0;i<bits.length;i++) {
			if(bits[i]==1 && other[i]==1)return false;
			if(bits[i]==0 && other[i]==0) {
				zeros=true;
			}
			if(bits[i]==1 || other[i]==1) {
				if(zeros)return false;
			}
		}
		return true;
	}
	static int[][] solve(int x,int y,boolean flipped) {
		int[]ans=new int[51];
		int[]dir=new int[51];
		for(int i=0;i<32;i++) {
			if(((x>>i)&1)==1) {
				ans[i]=1;
				if(flipped) {
					dir[i]=1;
				}
				else {
					dir[i]=0;
				}
				
			}
		}
		
		int[]bits=new int[51];
		for(int i=0;i<32;i++) {
			if(((y>>i)&1)==1) {
				bits[i]=1;
			}
		}
		if(check(bits, ans)) {
			for(int i=0;i<32;i++) {
				if(bits[i]==1) {
					ans[i]=1;
					if(!flipped) {
						dir[i]=1;
					}
					else {
						dir[i]=0;
					}
				}
			}
			return new int[][] {ans,dir};
		}
		if(y==0)return null;
		long pow=1;
		int log=0;
		while(pow<y) {
			pow<<=1;
			log++;
		}
		
		while(pow<=(1l<<50)) {
			long cur=pow-y;
			if(cur==0) {
				pow<<=1;
				log++;
				continue;
			}
			for(int i=0;i<32;i++) {
				if(((cur>>i)&1)==1) {
					bits[i]=1;
				}
				else {
					bits[i]=0;
				}
			}
			bits[log]=1;
			if(check(bits, ans)) {
				for(int i=0;i<32;i++) {
					if(bits[i]==1) {
						ans[i]=-1;
						if(!flipped) {
							dir[i]=1;
						}
						else {
							dir[i]=0;
						}
					}
				}
				ans[log]=1;
				if(!flipped) {
					dir[log]=1;
				}
				else {
					dir[log]=0;
				}
				return new int[][] {ans,dir};
			}
			pow<<=1;
			log++;
		}
		return null;
	}
	static StringBuilder print(int[]bits,int []dir,int x,int y) {
		StringBuilder ans=new StringBuilder();
		for(int i=0;i<51;i++) {
			if(bits[i]==1) {
				if(dir[i]==0) {//e or w
					if(x>0) {
						ans.append('E');
					}
					else {
						ans.append('W');
					}
				}
				else {//n or s
					if(y>0) {
						ans.append('N');
					}
					else {
						ans.append('S');
					}
				}
			}
			else {
				if(bits[i]==-1) {
					if(dir[i]==0) {//e or w
						if(x<0) {
							ans.append('E');
						}
						else {
							ans.append('W');
						}
					}
					else {//n or s
						if(y<0) {
							ans.append('N');
						}
						else {
							ans.append('S');
						}
					}
				}
				
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int x=sc.nextInt(),y=sc.nextInt();
			int[][]opt1=solve(Math.abs(x), Math.abs(y),false),opt2=solve(Math.abs(y), Math.abs(x),true);
			
			if(opt1==null && opt2==null) {
				pw.println("IMPOSSIBLE");
				continue;
			}
			if(opt1==null) {
				pw.println(print(opt2[0], opt2[1], x, y));
			}
			else {
			
				pw.println(print(opt1[0], opt1[1], x, y));
				
				
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
}