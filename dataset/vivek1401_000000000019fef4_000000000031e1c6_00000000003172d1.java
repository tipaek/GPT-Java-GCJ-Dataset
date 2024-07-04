import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	private static void solveTC(int __) {

//		/* For Google */
		ans.append("Case #").append(__).append(": ");
		
		//code start
		
		int n = scn.nextInt();
		int d = scn.nextInt();
		
		HashMap<Long, Integer> freqMap = new HashMap<>();
		
		long[] array = scn.nextLongArray(n);
		
		boolean OKtwo = false;
		
		for (long ele : array) {
			if (freqMap.containsKey(ele)) {
				freqMap.put(ele, freqMap.get(ele) + 1);
				OKtwo = true;
			} else {
				freqMap.put(ele, 1);
			}
		}
		
		if (d == 2) {
			if (OKtwo) {
				print(0);
			} else {
				print(1);
			}
		} else {
			for (int ele : freqMap.values()) {
				if (ele >= 3) {
					print(0);
					print("\n");
					return;
				}
			}
			if (OKtwo) {
				print(1);
			} else {
				for (long ele : array) {
					if (ele % 2 == 0) {
						if (freqMap.containsKey(ele / 2L)) {
							print(1);
							print("\n");
							return;
						}
					}
				}
				
				for (long ele : array) {
					if (ele > 180L * 1000_000_000L) {
						long leftOver = 180L * 1000_000_000L - ele;
						if (leftOver % 2 == 0 && freqMap.containsKey(leftOver / 2L)) {
							print(1);
							print("\n");
							return;
						}
					}
				}
				
				print(2);
			}
		}
		print("\n");
		
		
		//code end

//		ans.append("\n");
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