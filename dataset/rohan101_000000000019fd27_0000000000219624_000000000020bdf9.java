

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static final int INF = (int) (1e9 + 10);
	static final int MOD = (int) (1e9 + 7);
	// static final int N = (int) (4e5 + 5);
	// static ArrayList<Integer>[] graph;
	// static boolean visited[];
	// static int size[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner scn = new Scanner(System.in);
		//
		int t = sc.nextInt();
		for (int p = 1; p <= t; p++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][2];
			int ans[] = new int[1441];
			ArrayList<Integer> g = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt();
				ans[arr[i][0]]++;
				g.add(arr[i][0]);
				;
				arr[i][1] = sc.nextInt();
				ans[arr[i][1]]--;
			}
			StringBuilder sb = new StringBuilder();
			int max = 0;

			for (int i = 1; i < ans.length; i++) {
				ans[i] += ans[i - 1];
				max = Math.max(ans[i], max);
				// pr.println(i+" " +ans[i]);
			}
			if (max > 2)
				pr.println("Case #" + p + ": IMPOSSIBLE");
			else {
				ans = new int[1441];
				HashSet<Integer> h = new HashSet<>();
				for (int i = 0; i < n; i++) {
					if (ans[arr[i][0]] == 0) {
						int f=0;
						for (int j = arr[i][0]; j < arr[i][1]; j++) {
							if(ans[j] == 1){
								f=1;
								break;
							}
							
						}
						if(f==0){
							for (int j = arr[i][0]; j < arr[i][1]; j++) 
								ans[j]=1;
						h.add(i);}
					}
				}
				for (int i = 0; i < n; i++) {
					if (h.contains(i))
						sb.append("C");
					else
						sb.append("J");

				}
				pr.println("Case #" + p + ": " + sb);
			}
		}
		//
		// coded to perfection by Rohan Mukhija
		pr.flush();
		pr.close();
	}

	/*
	 * Template From Here
	 */
	private static boolean possible(long[] arr, int[] f, long mid, long k) {
		long c = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] * f[f.length - i - 1]) > mid) {
				c += (arr[i] - (mid / f[f.length - i - 1]));
			}
		}
		// System.out.println(mid+" "+c);
		if (c <= k)
			return true;
		return false;
	}

	public static int lowerBound(ArrayList<Integer> array, int length, long value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	public static void sortbyColumn(int[][] att, int col) {
		// Using built-in sort function Arrays.sort
		Arrays.sort(att, new Comparator<int[]>() {

			@Override
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {

				// To sort in descending order revert
				// the '>' Operator
				// if (entry1[col] > entry2[col])
				// return 1;
				// else //(entry1[col] >= entry2[col])
				// return -1;
				return new Integer(entry1[col]).compareTo(entry2[col]);
				// return entry1[col].
			}
		}); // End of function call sort().
	}

	static class pair {
		int V, I;

		pair(int v, int i) {
			V = v;
			I = i;
		}
	}

	public static int[] swap(int data[], int left, int right) {
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		return data;
	}

	public static int[] reverse(int data[], int left, int right) {
		while (left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}
		return data;
	}

	public static boolean findNextPermutation(int data[]) {
		if (data.length <= 1)
			return false;

		int last = data.length - 2;
		while (last >= 0) {
			if (data[last] < data[last + 1]) {
				break;
			}
			last--;
		}
		if (last < 0)
			return false;

		int nextGreater = data.length - 1;
		for (int i = data.length - 1; i > last; i--) {
			if (data[i] > data[last]) {
				nextGreater = i;
				break;
			}
		}
		data = swap(data, nextGreater, last);
		data = reverse(data, last + 1, data.length - 1);
		return true;
	}

	static long nCr(long n, long r) {
		if (n == r)
			return 1;
		return fact(n) / (fact(r) * fact(n - r));
	}

	static long fact(long n) {
		long res = 1;
		for (long i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

	/*
	 * static boolean prime[] = new boolean[1000007];
	 * 
	 * public static void sieveOfEratosthenes(int n) {
	 * 
	 * for (int i = 0; i < n; i++) prime[i] = true; * for (int p = 2; p * p <=
	 * n; p++) { // If prime[p] is not changed, then it is a prime if (prime[p]
	 * == true) { // Update all multiples of p for (int i = p * p; i <= n; i +=
	 * p) prime[i] = false; } }
	 * 
	 * // Print all prime numbers // for(int i = 2; i <= n; i++) // { //
	 * if(prime[i] == true) // System.out.print(i + " "); // } }
	 */

	static long power(long fac2, int y, int p) {
		long res = 1;
		fac2 = fac2 % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * fac2) % p;
			fac2 = (fac2 * fac2) % p;
		}
		return res;
	}

	static long modInverse(long fac2, int p) {
		return power(fac2, p - 2, p);
	}

	static boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	public static BigInteger lcmm(String a, String b) {
		BigInteger s = new BigInteger(a);
		BigInteger s1 = new BigInteger(b);
		BigInteger mul = s.multiply(s1);
		BigInteger gcd = s.gcd(s1);
		BigInteger lcm = mul.divide(gcd);
		return lcm;
	}

}
