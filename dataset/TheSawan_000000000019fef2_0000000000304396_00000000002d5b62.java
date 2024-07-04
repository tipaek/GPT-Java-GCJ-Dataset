import java.io.*;
import java.util.*;

public class Solution{
	static class zz{
		StringBuilder z;
		int x;int y;int pow;
		zz(StringBuilder o,int xx,int yy,int p) {
			x=xx;y=yy;
			z=new StringBuilder();
			z.append(o);
			pow=p;
		}
	}
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int x=sc.nextInt(),y=sc.nextInt();
			
			LinkedList<zz>q=new LinkedList<>();
			q.add(new zz(new StringBuilder(), x, y,1));
			StringBuilder ans=null;
			
			while(true) {
				zz cur=q.pollFirst();
//				System.out.println(cur.z+" "+cur.x+" "+cur.y+" "+cur.pow);
				if(cur.z.length()>12)break;
				if(cur.x==0 && cur.y==0) {
					ans=cur.z;
					break;
				}
				int curpow=cur.pow;
				zz newcur=new zz(cur.z, cur.x, cur.y,curpow<<1);
				newcur.z.append('S');
				newcur.y-=curpow;
				
				zz newcur2=new zz(cur.z, cur.x, cur.y,curpow<<1);
				newcur2.z.append('N');
				newcur2.y+=curpow;
				
				zz newcur3=new zz(cur.z, cur.x, cur.y,curpow<<1);
				newcur3.z.append('E');
				newcur3.x+=curpow;
				
				zz newcur4=new zz(cur.z, cur.x, cur.y,curpow<<1);
				newcur4.z.append('W');
				newcur4.x-=curpow;
				
				q.add(newcur);
				q.add(newcur2);
				q.add(newcur3);
				q.add(newcur4);
			}
			if(ans==null) {
				pw.println("IMPOSSIBLE");
			}
			else {
				pw.println(ans);
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