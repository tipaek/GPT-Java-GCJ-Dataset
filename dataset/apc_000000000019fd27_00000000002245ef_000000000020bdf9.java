//package code;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
	static int[] start;
	static int[] end;
	static String[] workerOfJob;
	static String[] workers;

	static boolean allocJob(int jobNum) {
		for (int i = 0; i < workers.length; ++i) {
			if (!workers[i].isEmpty()) {
				workerOfJob[jobNum] = workers[i];
				workers[i] = "";
				return true;
			}
		}
		return false;
	}

	static void finishJob(int jobNum) {
		for (int i = 0; i < workers.length; ++i) {
			if (!workers[i].isEmpty()) continue;
			workers[i] = workerOfJob[jobNum];
			break;
		}
	}

	static void case3(Scanner in, int caseNum) {
		N = in.nextInt();
		start = new int[N];
		end = new int[N];
		workerOfJob = new String[N];
 		workers = new String[] {"C", "J"};

		for (int i = 0; i < N; ++i) {
			start[i] = in.nextInt();
			end[i] = in.nextInt();
		}

		for (int i = 0; i <= 24 * 60; ++i) {
			for (int s = 0; s < N; ++s) {
				if (end[s] == i) {
					finishJob(s);
				}
			}
			for (int s = 0; s < N; ++s) {
				if (start[s] == i) {
					if (!allocJob(s)) {
						System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
						return;
					}
				}
			}
		}

		String result = "";
		for (int s = 0; s < N; ++s) result += workerOfJob[s];

		System.out.println("Case #" + caseNum + ": " + result);
	}

	static void case2(Scanner in, int caseNum) {
		final String src = in.next();
		String result = "";
		int curLevel = 0;
		for (int i = 0; i < src.length(); ++i) {
			final int digit = src.charAt(i) - 0x30;
			final int delta = digit - curLevel;
			for (int l = delta; l < 0; ++l) result += ")";
			for (int l = 0; l < delta; ++l) result += "(";
			result += digit;
			curLevel += delta;
		}
		for (int l = 0; l < curLevel; ++l) result += ")";

		System.out.println("Case #" + caseNum + ": " + result);
	}

	static int N;
	static int K;
	static int[][] matrix;
	static int[] buf;

	static boolean checkDiagonal(int src, int dst) {
		int k = 0;
		for (int d = 0; d < N; ++d) {
			final int D = (d == src)? dst: (d == dst? src: d);
			k += matrix[D][d];
		}
		return k == K;
	}

	static boolean swap(int src, int dst) {
		if (checkDiagonal(src, dst)) {
			System.arraycopy(matrix[src], 0, buf, 0, buf.length);
			System.arraycopy(matrix[dst], 0, matrix[src], 0, buf.length);
			System.arraycopy(buf, 0, matrix[dst], 0, buf.length);
			return true;
		}
		else return false;
	}

	static void case5(Scanner in, int caseNum) {
		N = in.nextInt();
		K = in.nextInt();
		matrix = new int[N][N];
		buf = new int[N];
		boolean isOk = false;

		int start = (K /*+ (N / 2)*/) / N;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (start > N) start -= N;
				matrix[i][j] = start++;
			}
			start--;
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i == j && i != 0) continue;
				if (!swap(i, j)) continue;
				isOk = true;
				break;
			}
		}

		System.out.println("Case #" + caseNum + ": " + (isOk? "POSSIBLE": "IMPOSSIBLE"));
		if (!isOk) return;
		StringBuilder row = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				row.append(matrix[i][j]).append(' ');
			}
			System.out.println(row.toString());
			row.setLength(0);
		}
	}

	static String case1(Scanner in) {
		final int N = in.nextInt();
		final int[][] matrix = new int[N][N];
		for (int row = 0; row < N; ++row) {
			for (int column = 0; column < N; ++column) {
				matrix[row][column] = in.nextInt();
			}
		}
		int k = 0;
		for (int d = 0; d < N; ++d) k += matrix[d][d];

		int dupRows = 0, dupColumns = 0;
		final int[] testLine = new int[N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) testLine[j] = 0;
			for (int j = 0; j < N; ++j) {
				testLine[matrix[i][j] - 1] += 1;
			}
			for (int j = 0; j < N; ++j) {
				if (testLine[j] != 0) continue;
				++dupRows;
				break;
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) testLine[j] = 0;
			for (int j = 0; j < N; ++j) {
				testLine[matrix[j][i] - 1] += 1;
			}
			for (int j = 0; j < N; ++j) {
				if (testLine[j] != 0) continue;
				++dupColumns;
				break;
			}
		}
		return "" + k + " " + dupRows + " " + dupColumns;
	}

	static String echo(Scanner in) {
		return in.next();
	}

	static String caseEntry(Scanner in)
	{
		StringBuffer result;
		SortedSet<BigInteger> vocabulary = new TreeSet<>();
		BigInteger maxCode = in.nextBigInteger();
		int strLen = in.nextInt();

		result = new StringBuffer(strLen + 1);
		BigInteger codes[] = new BigInteger[strLen + 1];
		BigInteger src[] = new BigInteger[strLen];
		BigInteger prevProd = new BigInteger("0");
		int initIndex = -1;

		// Read all sequence and mark first position where neighbor values differ
		for (int i = 0; i < strLen; ++i)
		{
			src[i] = in.nextBigInteger();
			if (i == 0) prevProd = src[i];
			else {
				if (initIndex < 0 && prevProd.compareTo(src[i]) != 0) initIndex = i - 1;
			}
		}

		// Calculate first possible codes
		BigInteger gcd = src[initIndex].gcd(src[initIndex + 1]);
		codes[initIndex] = src[initIndex].divide(gcd);
		codes[initIndex + 1] = gcd;
		codes[initIndex + 2] = src[initIndex + 1].divide(gcd);

		// Unrolling codes back starting from initIndex
		for (int i = initIndex; i >= 1; --i) codes[i - 1] = src[i - 1].divide(codes[i]);

		// Unrolling codes forward starting from initIndex
		for (int i = initIndex + 2; i < strLen; ++i) codes[i + 1] = src[i].divide(codes[i]);

		Collections.addAll(vocabulary, codes);

		// Generating the result
		for (BigInteger code: codes) {
			int charIndex = 0x41 + vocabulary.headSet(code).size();
			result.append((char)charIndex);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream(new File("/Users/apc/Desktop/Jam2020/src/main/java/code/test.in"));
			System.setIn(is);
		}
		catch (Throwable ignored) {}

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			case3(in, i);
//			case2(in, i);
//			System.out.println("Case #" + i + ": " + case1(in));

//			case5(in, i);
//			System.out.println("Case #" + i + ": " + case1(in));
		}
	}
}
