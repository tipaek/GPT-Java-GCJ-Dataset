import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			System.out.print("Case #" + (t+1) + ": ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			
			Slice[] sc = new Slice[N];
			for (int i = 0; i < N; i++) 
				sc[i] = new Slice(Long.parseLong(st.nextToken()));
			
			Arrays.sort(sc);
			for (int p = N-1; p >= 0; p--) {
				for (int q = p-1; q >= 0; q--) {
					long pt = sc[p].size;
					long qt = sc[q].size;
					
					sc[q].add(pt / qt);
					if (pt % qt == 0) 
						sc[q].Mults.addFirst(pt/qt);
				}
			}
			
			long max = 0;
			for (Slice s: sc) {
				if (s.total >=  D-1) {
					max = Math.max(max, doubleNum(s, D));
				}
			}
			
			System.out.println(D -  max - 1);
		}
		
	}
	private static long doubleNum(Slice a, int D) {
		long sum = 1;
		int amt = 0;
		for (long dv: a.Mults) {
			sum += dv;
			if (sum <= D) 
				amt++;
		}
		
		return amt;
	}
	
	static class Slice implements Comparable<Slice> {
		long size;
		LinkedList<Long> Mults = new LinkedList<Long>();
		long total = 0;
		
		public Slice(long size) {this.size = size;}
		
		public void add(long amt) {total += amt;}

		
		public int compareTo(Slice o) {
			if (size > o.size)  return 1;
			if (size == o.size) return 0;
			if (size < o.size)  return -1; 
			
			return 0;
		}
	}
}