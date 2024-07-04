
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {

	public static class HashingUtility {
		//If tle comes we can reduce number of hashes to even two...
		//Utilities
		final int[] m = new int[] { (int) 1e9 + 7, (int) 982451653, (int) 2038074743 };
		final int[] p = new int[] { (int) 3571, (int) 7919, (int) 541 };
		public int max;
		long[][] pre;
		long[][] invpre;
		int primes;
		String main_str;

		public long fast(long a, long n, long mod) { // used for inverse calculation and power calculation
			if (n == 0) {
				return 1;
			} else if (n == 1) {
				return a % mod;
			}
			long ans = fast(a, n / 2, mod);
			ans = ans * ans;
			ans %= mod;
			if ((n & 1) == 1) {
				ans = ans * (a % mod);
				ans %= mod;
			}
			return ans;
		}

		public HashingUtility(int primes, int max) {
			this.max = max;
			this.primes = primes;
			pre = new long[max][primes];
			invpre = new long[max][primes];
			PreCompute();
		}

		public void PreCompute() {
			//creates powers and inverse powers for each hash
			for (int i = 0; i < primes; i++) {
				long val = p[i];
				pre[0][i] = 1;
				invpre[0][i] = 1;
				long invval = fast(p[i], m[i] - 2, m[i]);
				long mod = m[i];
				for (int j = 1; j < max; j++) {
					pre[j][i] = (pre[j - 1][i] * val) % mod;
					invpre[j][i] = (invpre[j - 1][i] * invval) % mod;
				}
			}
		}

	}

	public static class HashingTemplate {
		HashingUtility utis;
		int[][] prefix;
		int[][] suffix;
		String str;
		int primes;
		int n;

		public HashingTemplate(HashingUtility utis, String str, int primes) {
			this.str = str;
			this.utis = utis;
			this.n = str.length();
			this.primes = primes;
			prefix = new int[n][primes];
			suffix = new int[n][primes];
			PREFIX();
			SUFFIX();
		}

		public int add(int a, int b, int mod) {
			long ans = (long) a + (long) b;
			if (ans >= mod) {
				ans -= mod;
			}
			return (int) ans;
		}

		public int mul(int a, int b, int mod) {
			long ans = (long) a * (long) b;
			if (ans >= mod) {
				ans %= mod;
			}
			return (int) ans;
		}

		public int get(char cc) {
//			if (cc >= 'a' && cc <= 'z') {
//				return cc - 'a' + 1;
//			}
			if(cc == '*') return 1;
			//Considering only capital letters 
			return cc - 'A' + 2;
		}

		public void PREFIX() {
			for (int j = 0; j < primes; j++) {
				prefix[0][j] = get(str.charAt(0));
				int mod = utis.m[j];
				for (int i = 1; i < n; i++) {
					prefix[i][j] = add(prefix[i - 1][j], mul(get(str.charAt(i)), (int) utis.pre[i][j], mod), mod);
				}
			}
		}

		public void SUFFIX() {
			for (int j = 0; j < primes; j++) {
				suffix[n - 1][j] = get(str.charAt(n - 1));
				int mod = utis.m[j];
				for (int i = n - 2; i >= 0; i--) {
					suffix[i][j] = add(suffix[i + 1][j], mul(get(str.charAt(i)), (int) utis.pre[n - i - 1][j], mod),
							mod);
				}
			}
		}

		public int[] RangeHash_Prefix(int start, int end) {// here start refers to left and end refers to right
			int[] hashes = new int[primes];
			for (int i = 0; i < primes; i++) {
				long curr = (prefix[end][i] - (start == 0 ? 0 : prefix[start - 1][i]));
				if (curr < 0) {
					curr += utis.m[i];
				}
				curr *= utis.invpre[start][i];
				curr %= utis.m[i];
				hashes[i] = (int) curr;
			}
			return hashes;
		}

		public int[] RangeHash_Suffix(int start, int end) { // here start refers to left and end refers to right
			int[] hashes = new int[primes];
			for (int i = 0; i < primes; i++) {
				long curr = (suffix[start][i] - (end == n - 1 ? 0 : suffix[end + 1][i]));
				if (curr < 0) {
					curr += utis.m[i];
				}
				curr *= utis.invpre[n - end - 1][i];
				curr %= utis.m[i];
				hashes[i] = (int) curr;
			}
			return hashes;
		}

		public boolean check(int[] hash1, int[] hash2) {
			int n = hash1.length;
			for (int i = 0; i < n; i++) {
				if (hash1[i] != hash2[i]) {
					return false;
				}
			}
			return true;
		}
	}

	
	public static void solve() {
		int t = s.nextInt();
		HashingUtility utis = new HashingUtility(2, 1000);
		for(int z = 1; z <= t; z++) {
			int n = s.nextInt();
			String[] given = new String[n];
			HashingTemplate[] hashes = new HashingTemplate[n];
			for(int i = 0; i < n; i++) {
				given[i] = s.next();
				hashes[i] = new HashingTemplate(utis, given[i], 2);
			}
			int[] asterik = new int[n];
			int max = 0;
			for(int i = 0; i < n; i++) {
				int pos = -1;
				String str = given[i];
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) == '*') {
						pos = j;
						break;
					}
				}
				asterik[i] = pos;
				max = Integer.max(max, asterik[i]);
			}
			//solving for prefixes
			StringBuilder prefix = new StringBuilder();
			boolean check = true;
			int[] point = new int[n];
 			for(int i = 0; i < max && check; i++) {
				boolean choosen = false;
				char cc = '*';
				for(int j = 0; j < n; j++) {
					if(given[j].charAt(point[j]) != '*' ) {
						if(!choosen) {
							choosen = true;
							cc = given[j].charAt(point[j]);
						}else {
							if(cc != given[j].charAt(point[j])) {
								check = false;
								break;
							}
						}
						point[j]++;
					}
				}
				prefix.append(cc);
			}
			if(!check) {
				out.println("Case #"+z+": *");
				continue;
			}
			for(int i = 0; i < n; i++) {
				if(prefix.length() >= asterik[i]) {
					continue;
				}
				for(int j = prefix.length(); j <  asterik[i]; j++) {
					prefix.append(given[i].charAt(j));
				}
			}
			int[] last_asterik = new int[n];
			int min = 101;
			for(int i = 0; i < n; i++) {
				int pos = -1;
				for(int j = given[i].length() - 1; j >= 0; j--) {
					if(given[i].charAt(j) == '*') {
						pos = j;
						break;
					}
				}
				last_asterik[i] = pos;
				min = Integer.min(last_asterik[i], min);
			}
			//Solving middle
			StringBuilder middle = new StringBuilder();
			for(int i = 0; i < n; i++) {
				for(int j = asterik[i]; j < last_asterik[i]; j++) {
					char cc = given[i].charAt(j);
					if(cc == '*') {
						continue;
					}else {
						middle.append(cc);
					}
				}
			}
			//Suffix
			StringBuilder suffix = new StringBuilder();
			int[] pointer = new int[n];
			for(int i = 0; i < n ;i++) pointer[i] = given[i].length() - 1;
			for(int i = 0; i < 101 && check; i++) {
				boolean choosen = false;
				char cc = '*';
				for(int j = 0; j < n; j++) {
					if(given[j].charAt(pointer[j]) != '*' ) {
						if(!choosen) {
							choosen = true;
							cc = given[j].charAt(pointer[j]);
						}else {
							if(cc != given[j].charAt(pointer[j])) {
								check = false;
								break;
							}
						}
						pointer[j]--;
					}
				}
				if(cc == '*') {break;}
				suffix.append(cc);
			}
			if(!check) {
				out.println("Case #"+z+": *");
				continue;
			}
			for(int i = 0; i < n; i++) {
				if(pointer[i ] == '*') continue;
				for(int j = pointer[i]; ; j--) {
					if(given[i].charAt(j) == '*') break;
					suffix.append(given[i].charAt(j));
				}
			}
			suffix.reverse();
			StringBuilder ans = new StringBuilder();
			ans.append(prefix); 
			ans.append(middle);
			ans.append(suffix);
//			System.out.println(suffix);
			out.println("Case #"+z+": "+ans);
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		s = new FastReader();
		solve();
		out.close();
	}

	public static FastReader s;
	public static PrintWriter out;

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	
}
