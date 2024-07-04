import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int i, j, k;

			int noOfRowsWithRepeatedElements = 0;
			int noOfColumnsWithRepeatedElements = 0;

			int noOfCases = Integer.valueOf(br.readLine());
			
			String res[] = new String[noOfCases];

			for (i = 0; i < noOfCases; i++) {

				int matrixSize = Integer.valueOf(br.readLine());

				int matrix[][] = new int[matrixSize][matrixSize];

				int trace = 0;
				
				Map<Integer, Set<Integer>> columnMap = new HashMap<>();
				
				for (j = 0; j < matrixSize; j++) {

					String row = br.readLine();
					String[] rowElement = row.split(" ");
					Set<Integer> set = new HashSet<>();

					for (k = 0; k < matrixSize; k++) {

						matrix[j][k] = Integer.valueOf(rowElement[k]);
						set.add(matrix[j][k]);
						
						if (j == k) {
							trace = trace + matrix[j][k];
						}
						
						Set<Integer> columnSet = null;
						if(columnMap.get(k) != null) {
							columnSet = columnMap.get(k);
						} else {
							columnSet = new HashSet<>();
						}
						columnSet.add(matrix[j][k]);
						columnMap.put(k, columnSet);
					}
					
					if(set.size() != matrixSize) {
						noOfRowsWithRepeatedElements += 1;
					}
					
				}

				for(Map.Entry<Integer, Set<Integer>> columnMapEntry : columnMap.entrySet()) {
					if(columnMapEntry.getValue().size() != matrixSize) {
						noOfColumnsWithRepeatedElements += 1;
					}
				}
				
				
				res[i] = "Case #" + (i+1) + ": " + trace + " " + noOfRowsWithRepeatedElements + " "
						+ noOfColumnsWithRepeatedElements;
				
				trace = 0;
				noOfRowsWithRepeatedElements = 0;
				noOfColumnsWithRepeatedElements = 0;

			}
			
			for (i = 0; i < noOfCases; i++) {
				System.out.println(res[i]);
			}

		} catch (Exception ex) {

		}

	}

}
