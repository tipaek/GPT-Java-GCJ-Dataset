import java.io.*;
import java.util.*;

public class Main{
	static PrintWriter pw;
	static MScanner  sc;
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		int tc=sc.nextInt();
		o:for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int n=sc.nextInt(),d=sc.nextInt();
			boolean two=false,three=false;
			HashMap<Long, Integer>map=new HashMap<>();
			long[]in=new long[n];
			for(int i=0;i<n;i++) {
				in[i]=sc.nextLong();
				int occ=(map.getOrDefault(in[i], 0))+1;
				if(occ>=2) {
					two=true;
				}
				if(occ>=3) {
					three=true;
				}
				map.put(in[i], occ);
			}
			if(d==2) {
				if(two) {
					pw.println(0);
					continue;
				}
				pw.println(1);
			}
			else {
				if(three) {
					pw.println(0);
					continue;
				}
				shuffle(in);
				Arrays.sort(in);
				two=false;
				HashMap<Long,Integer>tmp=new HashMap<>();
				for(int i=0;i<n;i++) {
					if(two) {
						pw.println(1);
						continue o;
					}
					int occ=(tmp.getOrDefault(in[i], 0)+1);
					if(occ>=2) {
						two=true;
					}
					tmp.put(in[i], occ);
				}
				for(int i=0;i<n;i++) {
					long doub=in[i]*2;
					if(map.containsKey(doub)) {
						pw.println(1);
						continue o; 
					}
				}
				pw.println(2);
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