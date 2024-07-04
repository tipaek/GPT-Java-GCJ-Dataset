import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;
	static int[] offR = {-1,-1,0,0,1,1}, offK = {-1,0,-1,1,0,1};
	static long[][] pascals;
	static ArrayList<Integer> ansR, ansK;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		pascals = new long[40][];
		pascals[0] = new long[1];
		pascals[0][0] = 1;
		pascals[1] = new long[2];
		pascals[1][0] = 1;
		pascals[1][1] = 1;
		for(int i = 2; i < 40; i++) {
			pascals[i] = new long[i + 1];
			pascals[i][0] = 1; pascals[i][i] = 1;
			for(int j = 1; j < i; j++)
				pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
		}
		while(t --> 0) {
			long n = nextInt();
			ansR = new ArrayList<Integer>();
			ansK = new ArrayList<Integer>();
			recurse(0,0,1,n,new boolean[501][501]);
			System.out.println("Case #" + l++ + ": ");
			for(int i = ansR.size() - 1; i >= 0; i--) {
				System.out.println(ansR.get(i) + " " + ansK.get(i));
			}
		}
	}
	public static boolean recurse(int r, int k, long sum, long needed, boolean[][] reached) {
		if(sum > needed) return false;
		if(sum == needed) {
			ansR.add(r + 1);
			ansK.add(k + 1);
			return true;
		}
		reached[r][k] = true;
		ArrayList<Integer> max = new ArrayList<Integer>();
		outer:
		for(int i = 0; i < 6; i++) {
			if(checkBounds(reached, r + offR[i], k + offK[i],sum, needed)) {
				long t = pascals[r + offR[i]][k + offK[i]];
				for(int j = 0; j < max.size(); j++) {
//					System.out.println(max.get(j));
					if(pascals[offR[max.get(j)] + r][offK[max.get(j)] + k] < t) {
						max.add(j, i); continue outer;
					}
				}
				max.add(i);
			}
		}
		for(int i = 0; i < max.size(); i++) {
			if(recurse(r + offR[max.get(i)], k + offK[max.get(i)], sum + pascals[r + offR[max.get(i)]][k + offK[max.get(i)]], needed, reached)) {
				ansR.add(r + 1);
				ansK.add(k + 1);
				return true;
			}
		}
		reached[r][k] = false;
		return false;
	}
	public static boolean checkBounds(boolean[][] reached, int r, int k, long sum, long needed) {
		if(r < 0 || k < 0 || k > r || reached[r][k] || sum + pascals[r][k] > needed) return false;
		return true;
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
