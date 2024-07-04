import java.util.*;
import java.io.*;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			int N = in.nextInt();
			int c[] = new int[N];
			Range ar[] = new Range[N];
			for(int i = 0; i < N; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				ar[i] = new Range(l,r,i);
			}
			Arrays.sort(ar);
			boolean good = true;
			int r[] = new int[2];
			r[0] = r[1] = -1;
			for(int i = 0; i < N; i++) {
				Range seg = ar[i];
				for(int j = 0; j < 2; j++) {
					if(seg.l >= r[j]) {
						c[seg.id] = j;
						r[j] = seg.r;
						break;
					}
					if(j == 1) good = false;
				}
			}
			
			
			if(!good) {
				out.println("Case #"+runs+": IMPOSSIBLE");
			}
			else {
				out.print("Case #"+runs+": ");
				for(int ii : c) out.print(ii == 0 ? "C":"J");
				out.println();
			}
		}
		
		
		
		out.close();
	}
	
	static class Range implements Comparable<Range>{
		int l, r, id;
		public Range(int ll, int rr, int ii) {
			l=ll;
			r=rr;
			id=ii;
		}
		@Override
		public int compareTo(Range o) {
			return l-o.l;
		}
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	

}
