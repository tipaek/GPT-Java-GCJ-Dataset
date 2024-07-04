import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		int T = 0;
		while(T++<t) {
			int n = sc.nextInt();
			int[][] array = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					array[i][j] = sc.nextInt();
			int s = 0, r = 0, c = 0;
			for(int i = 0; i < n; i++)
				s += array[i][i];
			for(int i = 0; i < n; i++) {
				TreeSet<Integer> set = new TreeSet<>();
				for(int j = 0; j < n; j++)
					set.add(array[i][j]);
				if(set.size() < n)
					r++;
			}
			
			for(int j = 0; j < n; j++) {
				TreeSet<Integer> set = new TreeSet<>();
				for(int i = 0; i < n; i++)
					set.add(array[i][j]);
				if(set.size() < n)
					c++;
			}
			
			pw.printf("Case #%d: %d %d %d\n", T, s, r, c);
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
