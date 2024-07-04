import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
   	// Read number of test cases
	int numCases = in.nextInt();

	for (int i = 1; i <= numCases; i++) {
		int dimensione = in.nextInt();
		Map<Integer, Set<Integer>> rowsNumbers = new HashMap<>();
		Map<Integer, Set<Integer>> columnNumbers = new HashMap<>();

		for (int x = 0; x < dimensione; x++) {
			rowsNumbers.put(x, new HashSet<>());
			columnNumbers.put(x, new HashSet<>());
		}

		int matrixTrace = 0;
		for (int x = 0; x < dimensione; x++) {
			for (int y = 0; y < dimensione; y++) {
				int entry = in.nextInt();
				rowsNumbers.get(x).add(entry);
				columnNumbers.get(y).add(entry);
				if (x == y) {
					matrixTrace += entry;
				}
			}
		}

		int numRowsHavingDupliates = 0;
		int numColsHavingDupliates = 0;

		for (int x = 0; x < dimensione; x++) {
			if (rowsNumbers.get(x).size() < dimensione) {
				numRowsHavingDupliates++;
			}
			if (columnNumbers.get(x).size() < dimensione) {
				numColsHavingDupliates++;
			}
		}

		System.out.println("Case #" + i + ": " + matrixTrace + " " + numRowsHavingDupliates + " " + numColsHavingDupliates);
	}
  }
}