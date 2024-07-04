import java.util.*;
import java.io.*;

public class Solution {
	// Try to program this with my daughter jumping over my head!! :D
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int test = 1; test <= t; ++test) {
			int N = in.nextInt();
			int rowCount = 0;
			int trace = 0;
			boolean [][] colUsed = new boolean [N][N+1];
			boolean [] colWrong = new boolean[N];
			for (int i = 0; i < N; i++) {
				boolean [] usedRow = new boolean[N+1];
				boolean wrongRow = false;
				for (int j = 0; j < N; j++) {
					int current = in.nextInt();
					if (i == j) {
						trace += current;
					}
					if (usedRow[current]) {
						wrongRow = true;
					} else {
						usedRow[current] = true;
					}
					if (!colUsed[j][current]) {
						colUsed[j][current] = true;
					} else {
						colWrong[j] = true;
					}
				}
				if (wrongRow) {
					rowCount++;
				}
			}
			int colCount = 0;
			for (int j = 0; j < N; j++) {
				if (colWrong[j]) {
					colCount++;
				}
			}

			System.out.println(String.format("Case #%d: %d %d %d",test,trace,rowCount,colCount));
		}
			
		in.close();
	}

}
