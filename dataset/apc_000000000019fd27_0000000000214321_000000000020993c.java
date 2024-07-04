package code;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
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
			System.out.println("Case #" + i + ": " + case1(in));
		}
	}
}
