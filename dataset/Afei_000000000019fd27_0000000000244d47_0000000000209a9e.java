import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int B = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			if (!solve(in, B)) {
				break;
			}
			debug("" + askCnt);
		}
		in.close();
		// System.out.println(t);
	}

	static int askCnt = 0;

	private static boolean solve(Scanner in, int B) {
		askCnt = 0;
		switch (B) {
		case 10:
			return solve10(in);
		case 20:
			return solveLarge(in, 20);
		default:
			return solveLarge(in, 100);
		}
	}

	private static boolean solve10(Scanner in) {
		String ans = "";
		for (int i = 1; i <= 10; i++) {
			int resp = ask(in, i);
			ans += resp;
		}
		return submit(in, ans);
	}

	private static boolean solveLarge(Scanner in, int nBits) {
		int start = 0;
		BitSet bs = new BitSet(nBits);
		int idSame = -1;
		int idDiff = -1;
		int valueIdSame = -1;
		int valueIdDiff = -1;
		int leftRound = 0;
		while (start < nBits / 2) {
			if (idSame == -1 && idDiff == -1) {
				// first round
				leftRound = 5;
			} else if (idSame != -1 && idDiff != -1) {
				int r1 = ask(in, idDiff);
				// debug(idDiff + ":" + valueIdDiff + "/" + idSame + ":" +
				// valueIdSame);
				int r2 = ask(in, idSame);
				// debug(idDiff + ":" + r1 + "/" + idSame + ":" + r2);
				if (valueIdDiff != r1) {
					if (valueIdSame != r2) {
						debug("flip diff!= same!=");
						flip(bs, nBits);
					} else {
						reverse(bs, nBits);
					}
				} else {
					if (valueIdSame != r2) {
						debug("flip diff= same!=");
						reverse(flip(bs, nBits), nBits);
					} else {
						// no change
					}
				}
				valueIdDiff = r1;
				valueIdSame = r2;
				leftRound = 4;
			} else if (idDiff != -1) {
				int r1 = ask(in, idDiff);
				// 1 more time for 10 times alignment
				r1 = ask(in, idDiff);
				if (valueIdDiff != r1) {
					// flip or reverse
					debug("flip diff");
					flip(bs, nBits);
				}
				valueIdDiff = r1;
				leftRound = 4;
			} else {
				int r1 = ask(in, idSame);
				// 1 more time for 10 times alignment
				r1 = ask(in, idSame);
				if (valueIdSame != r1) {
					// flip or flip reverse
					debug("flip same");
					flip(bs, nBits);
				}
				valueIdSame = r1;
				leftRound = 4;
			}
			for (int i = 0; i < leftRound; i++) {
				int r1 = ask(in, start);
				int r2 = ask(in, nBits - 1 - start);

				if (r1 == r2) {
					idSame = start;
					valueIdSame = r1;
				} else {
					idDiff = start;
					valueIdDiff = r1;
				}
				bs.set(start, r1 == 1);
				bs.set(nBits - 1 - start, r2 == 1);
				start++;
			}
			debug(str(bs, nBits));
		}

		return submit(in, str(bs, nBits));
	}

	static String str(BitSet bs, int nBits) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nBits; i++) {
			sb.append(bs.get(i) ? "1" : "0");
		}
		return sb.toString();
	}

	static BitSet reverse(BitSet bs, int nBits) {
		// debug("reverse");
		int i = 0;
		int j = nBits - 1;
		while (i < j) {
			if (bs.get(i) != bs.get(j)) {
				bs.flip(i);
				bs.flip(j);
			}
			i++;
			j--;
		}
		return bs;
	}

	static BitSet flip(BitSet bs, int nBits) {
		// debug("flip");
		bs.flip(0, nBits);
		return bs;
	}

	private static void debug(String s) {
		final boolean output = false;
		if (output) {
			System.err.println(s);
		}
	}

	private static boolean submit(Scanner in, String s) {
		out("" + s);
		String r = in.next();
		debug(r);
		return r.equals("Y");
	}

	private static int ask(Scanner in, int i) {
		// debug("" + (i+ 1));
		askCnt++;
		out("" + (i + 1));
		return in.nextInt();
	}

	private static void out(String s) {
		System.out.println(s);
		System.out.flush();
	}

	static long mod = 1000000007;

	static long add(long a, long b) {
		long r = a + b;
		if (r < 0) {
			r += mod;
		}
		return r % mod;
	}

	static long mul(long a, long b) {
		return (a * b) % mod;
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	static String str(int[] a) {
		String[] str = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			str[i] = a[i] + "";
		}
		return String.join(" ", str);
	}

	static int[] getIntArr(Scanner in, int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		return arr;
	}

	static int[][] getIntArr(Scanner in, int row, int col) {
		int[][] arr = new int[row][];
		for (int i = 0; i < row; i++) {
			arr[i] = getIntArr(in, col);
		}
		return arr;
	}

	static char[] getCharArr(Scanner in, int size) {
		char[] arr = in.next().toCharArray();
		return arr;
	}

	static String[] getStringArr(Scanner in, int size) {
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.next();
		}
		return arr;
	}

	static Map<Integer, List<Integer>> getEdges(Scanner in, int size, boolean directed) {
		Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int i = 0; i < size; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			if (!edges.containsKey(from)) {
				edges.put(from, new ArrayList<Integer>());
			}
			edges.get(from).add(to);
			if (!directed) {
				if (!edges.containsKey(to)) {
					edges.put(to, new ArrayList<Integer>());
				}
				edges.get(to).add(from);
			}

		}
		return edges;
	}

	static class FastScanner implements Closeable {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
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

		@Override
		public void close() throws IOException {
			br.close();
		}
	}

}
