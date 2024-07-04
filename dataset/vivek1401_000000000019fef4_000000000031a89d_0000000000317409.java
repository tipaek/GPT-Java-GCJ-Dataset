import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static void solveTC(int __) {

//		/* For Google */
		ans.append("Case #").append(__).append(": ");
		
		//code start
		
		int x = scn.nextInt();
		int y = scn.nextInt();
		char[] array = scn.next().toCharArray();
		
		int[] Xs = new int[array.length + 1];
		int[] Ys = new int[array.length + 1];
		Xs[0] = x;
		Ys[0] = y;
		for (int i = 0; i < array.length; i++) {
			switch (array[i]) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
			}
			Xs[i + 1] = x;
			Ys[i + 1] = y;
		}
		
		for (int i = 0; i < Xs.length; i++) {
			if (Math.abs(Xs[i]) + Math.abs(Ys[i]) <= i) {
				print(i);
				print("\n");
				return;
			}
		}
		
		print("IMPOSSIBLE");
		
		//code end
		
		ans.append("\n");
	}
	
	private static int gcd(int i, int j) {
		return (j == 0) ? i : gcd(j, i % j);
	}
	
	static void print(Object obj) {
		ans.append(obj.toString());
	}
	
	public static void main(String[] args) {
		
		scn = new Scanner();
		int t = scn.nextInt();
//		int t = 1;
		for (int i = 1; i <= t; i++) {
			ans = new StringBuilder();
			solveTC(i);
			System.out.print(ans);
		}
		
	}
	
	static Scanner scn;
	static StringBuilder ans;
	
	//Fast Scanner
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() {
			br = new BufferedReader(new
					InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}
		
		Integer[] nextIntegerArray(int n) {
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}
		
		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}
			return array;
		}
		
		String[] nextStringArray() {
			return nextLine().split(" ");
		}
		
		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = next();
			}
			return array;
		}
	}
}