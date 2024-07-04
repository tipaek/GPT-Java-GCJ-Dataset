import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws Exception{
		PrintWriter pw=new PrintWriter(System.out);
		MScanner sc = new MScanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			pw.print("Case #"+test+": ");
			int n=sc.nextInt();
			char[][]in=new char[n][];
			for(int i=0;i<n;i++) {
				in[i]=(sc.nextLine()+'*').toCharArray();
			}
			int[]pointers=new int[n];
			boolean yes=true;
			StringBuilder ans=new StringBuilder();
			int cnt=0;
			while(yes) {
				cnt++;
				int max=-1;
				int maxi=-1;
				StringBuilder[]s=new StringBuilder[n];
				for(int i=0;i<n;i++) {
					s[i]=new StringBuilder();
					while(pointers[i]<in[i].length && in[i][pointers[i]]!='*') {
						s[i].append(in[i][pointers[i]++]);
					}
					pointers[i]++;
					if(s[i].length()>max) {
						max=s[i].length();
						maxi=i;
					}
				}
				boolean ok=true;
				for(int i=0;i<n;i++) {
					if(pointers[i]<in[i].length) {
						ok=false;
					}
				}
				if(cnt==1) {
					for(int i=0;i<n;i++) {
						if(maxi==i)continue;
						int j=0;
						while(j<s[i].length()) {
							if(s[i].charAt(j)!=s[maxi].charAt(j)) {
								yes=false;
							}
							j++;
						}
					}
					for(int i=0;i<s[maxi].length();i++) {
						ans.append(s[maxi].charAt(i));
					}
				}
				else {
					if(ok) {
						for(int i=0;i<n;i++) {
							if(maxi==i)continue;
							int j=s[i].length()-1;
							int k=s[maxi].length()-1;
							while(j>=0) {
								if(s[i].charAt(j)!=s[maxi].charAt(k)) {
									yes=false;
								}
								j--;k--;
							}
						}
						for(int i=0;i<s[maxi].length();i++) {
							ans.append(s[maxi].charAt(i));
						}
					}
					else {
						for(int i=0;i<n;i++) {
							ans.append(s[i]);
						}
					}
				}
				
				
				
				if(ok)break;
			}
			pw.println(yes?ans:"*");
			
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