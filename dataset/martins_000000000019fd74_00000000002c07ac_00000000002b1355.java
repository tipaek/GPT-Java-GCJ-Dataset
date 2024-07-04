import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			sb.append("Case #"+test+": "); test++;
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[][] arr = new long[n][m];
			HashSet<Integer>[] alive = new HashSet[n];
			TreeSet<Integer>[] byrow = new TreeSet[n];
			TreeSet<Integer>[] bycol = new TreeSet[m];
			for(int i = 0; i < n; i++) {
				alive[i] = new HashSet<>();
				byrow[i] = new TreeSet<>();
				for(int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
					alive[i].add(j);
					byrow[i].add(j);
				}
			}
			for(int j = 0; j < m; j++) {
				bycol[j] = new TreeSet<>();
				for(int i = 0; i < n; i++) {
					bycol[j].add(i);
				}
			}
			long res = 0;
			boolean changed = true;
			while(changed) {
				changed = false;
				for(int i = 0; i < n; i++) {
					for(int j: alive[i]) {
						res += arr[i][j];
					}
				}
				ArrayList<Pair> kill = new ArrayList<>();
				for(int i = 0; i < n; i++) {
					for(int j: alive[i]) {
						int neigh = 0;
						long sum = 0;
						Integer west = byrow[i].lower(j);
						if(west != null) {
							neigh++; sum += arr[i][west];
						}
						Integer east = byrow[i].higher(j);
						if(east != null) {
							neigh++; sum += arr[i][east];
						}
						Integer north = bycol[j].lower(i);
						if(north != null) {
							neigh++; sum += arr[north][j];
						}
						Integer south = bycol[j].higher(i);
						if(south != null) {
							neigh++; sum += arr[south][j];
						}
						if(neigh > 0 && arr[i][j] * neigh < sum) {
							kill.add(new Pair(i, j)); changed = true;
						}
					}
				}
				for(Pair p: kill) {
					alive[p.x].remove(p.y);
					byrow[p.x].remove(p.y);
					bycol[p.y].remove(p.x);
				}
			}
			sb.append(String.format("%d\n", res));
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
