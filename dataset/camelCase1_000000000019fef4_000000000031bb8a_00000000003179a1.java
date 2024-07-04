import java.util.*;
import java.io.*;
public class Randomized {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		PrintWriter out = new PrintWriter(System.out);
		while(t --> 0) {
			int u = nextInt();
			int[] poss = new int[26];
			boolean[] used = new boolean[26];
			for(int i = 0; i < 10000; i++) {
				nextInt();
				char[] arr = next().toCharArray();
//				if(arr.length == u)
					poss[arr[0] - 'A']++;
				for(int j = 0; j < arr.length; j++)
					used[arr[j] - 'A'] = true;
			}
			int largest = 0;
			String ans = "";
			for(int j = 0; j < 9; j++) {
				for(int i = 1; i < 26; i++) {
					if(poss[i] > poss[largest]) largest = i;
				}
				used[largest] = false;
				poss[largest] = 0;
				ans += (char) (largest + 'A');
			}
			for(int i = 0; i < 26; i++)
				if(used[i]) {
					ans = (char) (i + 'A') + ans;
					break;
				}
			out.println("Case #" + (l++) + ": " + ans);
		}
		out.close();
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
}
