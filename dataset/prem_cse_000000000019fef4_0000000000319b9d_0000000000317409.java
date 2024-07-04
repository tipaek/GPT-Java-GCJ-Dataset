import java.io.*;
import java.util.*;


public class Solution {

	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer root;
		
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (root == null || !root.hasMoreTokens()) {
				try {
					root = new StringTokenizer(br.readLine());
				} catch (Exception addd) {
					addd.printStackTrace();
				}
			}
			return root.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception addd) {
				addd.printStackTrace();
			}
			return str;
		}
	}
	

	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	
	public static FastReader sc = new FastReader();
 
	static int mod = (int) (1e9+7),MAX=(int) (1e6+100);
	static List<Integer>[] edges;
    static int[][] dp;
    static int[] a;
    static List<Integer> order;
	
	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			  int y = sc.nextInt();
			  int x = sc.nextInt();
			  int ans = 0;
			  int man = Math.abs(x) + Math.abs(y);
			  int time = 0;
			  
			  char[] s = sc.next().toCharArray();
			  boolean found = false;
			  if(time >= man) {
				  ans = time;
				  found = true;
			  }
			  for(int i=0;i<s.length && !found;++i) {
				  if(s[i] == 'N') {
					  ++x;
				  }else if(s[i] == 'S') {
					  --x;
				  }else if(s[i] == 'E') {
					  ++y;
				  }else if(s[i] == 'W')
					  --y;
				  ++time;
				 if(Math.abs(x) + Math.abs(y) <= time) {
					 ans = time;
					 found = true;
				 }
			  }
			  if(found) out.println("Case #"+t+": "+ans);
			  else out.println("Case #"+t+": IMPOSSIBLE");
		  }
		  out.close();
		 }

	
	}

