import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int d = Integer.parseInt(tokenizer.nextToken());
			StringTokenizer aT = new StringTokenizer(reader.readLine());
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(aT.nextToken());
			}
			Arrays.sort(a);

			Set<Long> set = new TreeSet<Long>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					set.add(gcd(a[i], a[j]));
				}
			}
			//set.add(1L);
			long answer = d - 1;
			for (long x : set) {
				//writer.println("Testing: " + x);
				long cleanPieces = 0;
				long cleanCuts = 0;
				long dirtyPieces = 0;
				for (long v : a) {
					long numPieces = v / x;
					if (v % x == 0) {
						if (cleanPieces + numPieces <= d) {
							cleanPieces += numPieces;
							cleanCuts += numPieces - 1;
						} else {
							dirtyPieces += numPieces;
							break;
						}
					} else {
						dirtyPieces += numPieces;
					}
				}
				if (cleanPieces + dirtyPieces >= d) {
					answer = Math.min(answer, cleanCuts + (d - cleanPieces));
				} else {
					if (d % cleanPieces == 0) {
						answer = Math.min(answer, cleanCuts + cleanPieces * (d / cleanPieces - 1));
					}
				}
			}
			writer.printf("Case #%d: %s\n", tt + 1, answer);
		}

		reader.close();
		writer.close();
	}
	public static long gcd(long a, long b) {
		return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
	}
}
