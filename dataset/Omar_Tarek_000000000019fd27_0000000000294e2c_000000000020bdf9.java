import java.util.*;
import java.io.*;

public class Solution {
	
	static int n;
	static ArrayList<Integer>[] adjList;
	static int[] color;
	static boolean[] vis;
	static boolean ans;
	
	public static void dfs(int u) {
		vis[u] = true;
		for(int v : adjList[u]) {
			if(!vis[v]) {
				color[v] = 1 - color[u];
				dfs(v);
			} else {
				if(color[v] == color[u]) {
					ans = false;
				}
			}
		}
	}
	
	public static boolean overlap(int x1, int x2, int y1, int y2) {
		if(x2 <= y1)
			return false;
		if(x1 >= y2)
			return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			n = sc.nextInt();
			adjList = new ArrayList[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			int[] start = new int[n];
			int[] end = new int[n];
			for(int i = 0; i < n; i++) {
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					if(overlap(start[i], end[i], start[j], end[j])) {
						adjList[i].add(j);
						adjList[j].add(i);
					}
				}
			}
			
			ans = true;
			vis = new boolean[n];
			color = new int[n];
			
			for(int i = 0; i < n; i++)
				if(!vis[i]) {
					color[i] = 0;
					dfs(i);
				}
			
			if(!ans) {
				pw.printf("Case #%d: IMPOSSIBLE\n", t);
			} else {
				StringBuilder sb = new StringBuilder("");
				for(int i = 0; i < n; i++)
					if(color[i] == 0)
						sb.append("J");
					else
						sb.append("C");
				pw.printf("Case #%d: %s\n", t, sb);
			}
		}
		
		pw.flush();
	}

	public static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();
			return array;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++)
				array[i] = new Integer(nextInt());
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();
			return array;
		}

		public double[] nextDoubleArray(int n) throws IOException {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();
			return array;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
