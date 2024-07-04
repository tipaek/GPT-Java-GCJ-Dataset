import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader()  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("p.txt"));
		}

		String next() {
			while(st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt()  {
			return Integer.parseInt(next());
		}
		long nextLong()  {
			return Long.parseLong(next());
		}
		double nextDouble()  {
			return Double.parseDouble(next());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st != null && st.hasMoreElements());
		}
	}


	static act[] a;
	static boolean v[];
	static int n;
	static final int inf = 2000;
	
	
	static StringBuilder solve() {
		int t = 0;
		int min_start;
		int min_idx = 0;
		for(int i = 0; i < n; i++) {
			min_start = inf;
			for(int j = 0; j < n; j++) {
				if (v[j] || a[j].start < t) continue;
				if (a[j].start < min_start) {
					min_idx = j;
					min_start = a[j].start;
				}
			}
			if (min_start == inf) break;
			v[min_idx] = true;
			t = a[min_idx].end;
		}
		
		boolean p = true;
		
		t = 0;
		min_start = 0;
		for(int i = 0; i < n && p; i++) {
			if(v[i]) continue;
			if (a[i].start < t) p = false;
			t = a[i].end;
		}
		StringBuilder result = new StringBuilder();
		String[] arr;
		if (p) {
			arr = new String[n];
			for(int i = 0; i < n;i++) {
				if (v[i]) {
					arr[a[i].index] = "C";
				} else {
					arr[a[i].index] = "J";
				}
			}
			for(int i = 0; i < n; i++) {
				result.append(arr[i]);
			}
		} else {
			result.append("IMPOSSIBLE");
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t,st,en;
		t = fr.nextInt();
		String result;
		for(int c = 1; c <=t; c++) {
			n = fr.nextInt();
			a = new act[n];
			v = new boolean[n];
			for(int i = 0; i < n; i++) {
				st = fr.nextInt();
				en = fr.nextInt();
				a[i] = new act(st,en,i);
			}
			Arrays.parallelSort(a);
			result = solve().toString();
			System.out.println("Case #" + c + ": " + result);
			

		}

	}






	static class act implements Comparable<act> {
		int start,end,index;

		public act(int start, int end, int index) {
			super();
			this.start = start;
			this.end = end;
			this.index = index;
		}

		@Override
		public int compareTo(act arg0) {
			if (this.start == arg0.start) {
				return this.end - arg0.end;
			} return this.start - arg0.start;
		}

		@Override
		public String toString() {
			return "act [start=" + start + ", end=" + end + "]\n";
		}


	}

}
