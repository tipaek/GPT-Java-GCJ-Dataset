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
			int n = sc.nextInt();
			int d = sc.nextInt();
			TreeMap<Long,Integer> map = new TreeMap<>();
			Long[] a = new Long[n];
			
			for(int i=0;i<n;++i) {
				a[i] = sc.nextLong();
				map.put(a[i],map.getOrDefault(a[i],0)+1);
			}
			int ans = 0;
			if(d == 2) {
				boolean two = false;
				for(int val : map.values()) {
					if(val > 1) two = true;
				}
				if(!two) ans = 1;
				else ans = 0;
			}else if(d == 3) {
				boolean three = false;
				for(int val : map.values()) {
					if(val > 2) three = true;
				}
				if(!three) {
					boolean two = false;
				   for(long key : map.keySet()) {
					   if(map.get(key) == 2 && key != map.lastKey()) {
						   two = true;
						   break;
					   }else if(map.containsKey(2*key)) {
						   two = true;
						   break;
					   }
				   }
				   if(two) ans = 1;
				   else {
					   ans = 2;
				   }

				}else ans = 0;
			}
			out.println("Case #"+t+": "+ans);
		  }
		  out.close();
		 }

	
	}

