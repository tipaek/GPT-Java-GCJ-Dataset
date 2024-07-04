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
 
	static int mod = (int) (1e9+7),MAX=(int) (1e4);
	static List<Integer>[] edges;
    static int[][] dp;
    static int[] a;
    static List<Integer> order;
	
	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			boolean[] map = new boolean[26];
			int u = sc.nextInt();
			int[] range = new int[26];
			Arrays.fill(range, Integer.MAX_VALUE);
			for(int i=0;i<4;++i) {
				int num = sc.nextInt();
				char[] s = sc.next().toCharArray();
				for(int j=0;j<s.length;++j) {
				    range[s[j]-'A'] = Math.min(num, range[s[j]-'A']);
				}
			}
			char[] ans = new char[10];
			int idx = 0;
			for(int i=1;i<=10;++i) {
				List<Character> list = new ArrayList<>();
 				for(int j=0;j<range.length;++j) {
					if(range[j] == i) {
						char c = (char) ('A'+j);
						list.add(c);
					}
 				}
					for(int j=0;idx < i && j < list.size();++idx) {
						ans[idx] = list.get(j);
						map[list.get(j)-'A'] = true;
					}
				
			}
			
			for(int i=0;idx<10 && i<map.length;++i) {
				if(!map[i]) {
					ans[idx++] = (char)(i+'A');
				}
			}
			out.println("Case #"+t+": "+new String(ans));
		  }
		  out.close();
		 }

	
	}
