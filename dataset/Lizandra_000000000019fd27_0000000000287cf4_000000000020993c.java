
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
	public static final String CASE = "Case #";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCaseNumber = in.nextInt();
		StringBuffer output = new StringBuffer();
		int trace = 0;
		int num = 0;
		BitSet[] cols = null;
		BitSet row = null;
		int repCols = 0, repRows = 0;

		for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
			int n = in.nextInt();
			cols = new BitSet[n];
			row = new BitSet();
			trace = 0;
			repCols = 0;
			repRows = 0;

			for (int i = 0; i < n; ++i) {
				row.clear();
				for (int j = 0; j < n; ++j) {
					if (i == 0) {
						if (currentTestCase == 1) {
							cols[j] = new BitSet();
						} else {
							cols[j].clear();
						}
					}
					num = in.nextInt();
					if (i == j) {
						trace += num;
					}
					row.set(num % n); // index within 0-(n-1)
					cols[j].set(num % n);

					if ((i == (n - 1)) && (cols[j].cardinality() != n)) {
						repCols++;
					}
				}
				if (row.cardinality() != n) {
					repRows++;
				}
			}
			output.append(CASE + currentTestCase + ": ");
			output.append(trace + " ");
			output.append(repRows + " ");
			output.append(repCols + "\n");
		}
		in.close();
		System.out.println(output.toString());
	}
}
