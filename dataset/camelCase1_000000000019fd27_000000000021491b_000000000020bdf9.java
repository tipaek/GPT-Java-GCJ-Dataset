import java.util.*;
import java.io.*;
public class Competitive {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		outer:
		while(t --> 0) {
			int n = nextInt();
			Item[] arr = new Item[n];
			for(int i = 0; i < n; i++)
				arr[i] = new Item(nextInt(), nextInt(), i);
			Arrays.sort(arr, null);
			Item c = null;
			Item j = null;
			boolean[] ans = new boolean[n];
			for(int i = 0; i < n; i++) {
				if(c == null || c.r <= arr[i].l) {
					c = arr[i];
				} else if(j == null || j.r <= arr[i].l) {
					j = arr[i];
					ans[j.id] = true;
				} else {
					System.out.println("Case #" + l++ + ": IMPOSSIBLE");
					continue outer;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				if(ans[i]) sb.append('J');
				else sb.append('C');
			}
			System.out.println("Case #" + l++ + ": " + sb);
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static class Item implements Comparable<Item> {
		int l, r, id;
		
		public Item(int l, int r, int id) {
			super();
			this.l = l;
			this.r = r;
			this.id = id;
		}


		@Override
		public int compareTo(Item o) {
			return r - o.r;
		}
		
		
	}
}

