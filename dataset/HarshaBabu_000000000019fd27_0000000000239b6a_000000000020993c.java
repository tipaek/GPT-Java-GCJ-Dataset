import java.io.*;
import java.util.*;

public class Vestigium {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}
	
	public static void solve(BufferedReader br) throws IOException {
		int numberOfTestCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= numberOfTestCases; i++) {

			long sum = 0, rowrepeats = 0, columnRepeats = 0;

			int matrixSize = Integer.parseInt(br.readLine());

			Map<Integer, Set<Long>> rowMap = new HashMap();

			Set<Integer> rowDupSet = new HashSet();

			for (int r = 0; r < matrixSize; r++) {
				String[] row = br.readLine().split(" ");

				Set<Long> columnSet = new HashSet();
				boolean noColdup = true;

				for (int c = 0; c < matrixSize; c++) {

					long colNum = Long.parseLong(row[c]);

					if (r == c) {
						sum += colNum;
					}
					if (noColdup && !columnSet.add(colNum)) {
						noColdup = false;
						rowrepeats++;
					}

					// columnRepeats finder
					if (!rowDupSet.contains(c)) {

						if (rowMap.containsKey(c)) {
							Set<Long> rowSet = rowMap.get(c);
							if (!rowSet.add(colNum)) {
								rowDupSet.add(c);
								columnRepeats++;

							}
						} else {
							Set<Long> rowSet = new HashSet();
							rowSet.add(colNum);
							rowMap.put(c, rowSet);
						}

					}
				}

			}

			System.out.println("Case #" + i + ": " + sum + " " + rowrepeats + " " + columnRepeats);
		}

	}
}
