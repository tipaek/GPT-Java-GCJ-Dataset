import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] argv) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		for (int i = 0; i < numCases; i++) {
			int matrixSize = in.nextInt();
			Map<Integer, Set<Integer>> columnElementsMap = new HashMap<>();
			int traceIndex = 0;
			int trace = 0;
			int rowsWithRepeats = 0;
			int columnsWithRepeats = 0;
			for (int j = 0; j < matrixSize; j++) {
				HashSet rowElements = new HashSet();
				List<Integer> row = new ArrayList<>();
				for (int k = 0; k < matrixSize; k++) {
					int next = in.nextInt();
					Set<Integer> columnElements = columnElementsMap.computeIfAbsent(k, key -> new HashSet<>());
					columnElements.add(next);
					if (k == traceIndex) {
						trace += next;
					}
					rowElements.add(next);
					row.add(next);
				}
				if (rowElements.size() != matrixSize) {
					rowsWithRepeats++;
				}
				traceIndex++;
			}
			for (Set<Integer> columnElements : columnElementsMap.values()) {
				if (columnElements.size() != matrixSize) {
					columnsWithRepeats++;
				}
			}
			System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, rowsWithRepeats, columnsWithRepeats));
		}
	}
}