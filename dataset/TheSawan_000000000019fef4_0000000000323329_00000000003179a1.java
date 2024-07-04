import java.io.*;
import java.util.*;

public class Solution{
	static PrintWriter pw;
	static MScanner  sc;
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		long[]pow10=new long[18];
		pow10[0]=1;
		for(int i=1;i<18;i++) {
			pow10[i]=(pow10[i-1]*10);
		}
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int u=sc.nextInt();
			int q=10000;
			char[][]qi=new char[q][];
			char[][]mi=new char[q][];
			
			char[]ans=new char[10];
			Arrays.fill(ans, '#');
			for(int i=0;i<q;i++) {
				long n=sc.nextLong();String m=sc.next();
				n=Math.min(n, pow10[m.length()]-1);
				qi[i]=(n+"").toCharArray();
				mi[i]=m.toCharArray();
			}
			int[]lower=new int[26];
			int[]upper=new int[26];
			Arrays.fill(lower, 0);
			Arrays.fill(upper, 9);
			int lo=1;
			boolean[]used=new boolean[26];
			for(int num=1;num<10;num++) {
				char x='#';
				o:for(int i=0;i<q;i++) {
					int d=0;
					while(d<qi[i].length) {
						if(qi[i][d]==((char)('0'+num)) && !(mi[i][d]>='0' && mi[i][d]<='9')) {
							x=mi[i][d];
							used[x-'A']=true;
							break o;
						}
						if(mi[i][d]>='A' && mi[i][d]<='Z') {
							int a=(mi[i][d]-'A');
							int b=qi[i][d]-'0';
//							System.out.println(Arrays.toString(qi[i])+" "+Arrays.toString(mi[i]));
							upper[a]=Math.min(upper[a], b);
						}
						if(qi[i][d]!=mi[i][d]) {
							break;
						}
						
						d++;
					}
				}
				ans[num]=x;
				if(ans[num]=='#')break;
				for(int i=0;i<q;i++) {
					for(int j=0;j<mi[i].length;j++) {
						if(mi[i][j]==ans[num]) {
							mi[i][j]=(char)('0'+num);
						}
					}
				}
			}
			for(int num=0;num<10;num++) {
				
				char x='#';
				if(ans[num]!=x)continue;
				o:for(int i=0;i<q;i++) {
					int d=0;
					while(d<qi[i].length) {
						if(qi[i][d]==((char)('0'+num)) && !(mi[i][d]>='0' && mi[i][d]<='9')) {
							x=mi[i][d];
							used[x-'A']=true;
							break o;
						}
						if(mi[i][d]>='A' && mi[i][d]<='Z') {
							int a=(mi[i][d]-'A');
							int b=qi[i][d]-'0';
							upper[a]=Math.min(upper[a], b);
						}
						if(qi[i][d]!=mi[i][d]) {
							break;
						}
						d++;
					}
				}
				ans[num]=x;
				if(ans[num]=='#')break;
				for(int i=0;i<q;i++) {
					for(int j=0;j<mi[i].length;j++) {
						if(mi[i][j]==ans[num]) {
							mi[i][j]=(char)('0'+num);
						}
					}
				}
			}
			for(int i=0;i<10;i++) {
				if(ans[i]!='#') {
					pw.print(ans[i]);
				}
				else {
					for(int c=0;c<26;c++) {
						if(!used[c]) {
							used[c]=true;
							char p=(char)('A'+c);
							pw.print(p);
							break;
						}
					}
				}
			}
			pw.println();
//			pw.println(Arrays.toString(upper));
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