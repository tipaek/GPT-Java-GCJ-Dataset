import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);

	
	public static void main(String[] args) {
		FS in = new FS();
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			long L = in.nextLong();
			long R = in.nextLong();
			
			long dif = Math.abs(R-L);
			
			long tilDif = 0;
			long lo = 1, hi = 2_000_000_000;
			while(lo <= hi) {
				long mid = (lo+hi)/2;
				if((mid*(mid+1))/2 <= dif) {
					tilDif = Math.max(tilDif, mid);
					lo = mid+1;
				}
				else hi = mid-1;
			}
			
			if(R > L) R -= (tilDif*(tilDif+1))/2;
			else L -= (tilDif*(tilDif+1))/2;
			
//			System.out.println("Til = "+tilDif+" "+L+" "+R);
			
			// now they alternate
			long big = Math.max(L,R);
			long small = Math.min(L, R);
			long next = 0;
			lo = 1; hi = 2_000_000_000;
			while(lo <= hi) {
				long mid = (lo+hi)/2;
				long lr[] = lr(tilDif+1, mid);
				if(lr[0] <= big && lr[1] <= small) {
					next = Math.max(next, mid);
					lo = mid+1;
				}
				else hi = mid-1;
			}
			
			long lr[] = lr(tilDif+1, next);
			
//			System.out.println("N = "+next+" "+Arrays.toString(lr));
			
			if(L >= R) { L -= lr[0]; R -= lr[1];}
			else { L -= lr[1]; R -= lr[0];}
			
			out.println("Case #"+runs+": "+(tilDif+next)+" "+L+" "+R);
		}

	
		out.close();
	}
	
	static long[] lr(long start, long steps) {
		if(steps == 0) return new long[] {0,0};
//		System.out.println("  "+start+" "+steps);
		long onLeft = (steps+1)/2;
		
		long sum = 2*(onLeft*(onLeft-1))/2;
		long L = start*onLeft + sum;
		
		long total = start*steps + (steps*(steps-1))/2;
		long R = total-L;
		return new long[] {L,R};
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
