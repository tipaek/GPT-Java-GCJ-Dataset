
import java.util.*;
import java.io.*;
class Result {
	String status;
	int[][] matrix;
}

public class Solution {
	public static Result createMatrix(int n, int k) {
		int[][] matrix = new int[n][n];
		int traceLeft = k;
		Map<Integer, Map<Integer, Boolean>> rowDuplicateMap = new HashMap<>();
        Map<Integer, Map<Integer, Boolean>> columnDuplicateMap = new HashMap<>();
        Result result = new Result();
        boolean isPossible = createMatrix(matrix, traceLeft, rowDuplicateMap, columnDuplicateMap, "", 0);
        result = new Result();
		result.status = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
		result.matrix = matrix;
      
		return result;
	}

	private static boolean createMatrix(int[][] matrix, int traceLeft, Map<Integer, Map<Integer, Boolean>> rowDuplicateMap, 
										Map<Integer, Map<Integer, Boolean>> columnDuplicateMap, String debug, int numPlaced) {

		//base case
		if (numPlaced == matrix.length*matrix.length) {
			return traceLeft == 0;
		}

		for (int i  = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				for (int potentialValue = 1; potentialValue <= matrix.length; potentialValue++) {
					boolean valueIsRowDuplicate = rowDuplicateMap.containsKey(i) && rowDuplicateMap.get(i).containsKey(potentialValue);
					boolean valueIsColDuplicate = columnDuplicateMap.containsKey(j) && columnDuplicateMap.get(j).containsKey(potentialValue);

					// this cell is valid
					if ((matrix[i][j] == 0 && (!valueIsRowDuplicate && !valueIsColDuplicate && i != j)) ||
						(matrix[i][j] == 0 && (i == j && potentialValue <= traceLeft && !valueIsRowDuplicate && !valueIsColDuplicate))) {

						// make move on this cell
						matrix[i][j] = potentialValue;
						//update states that keep track of duplicates
						if (!rowDuplicateMap.containsKey(i)) {
							rowDuplicateMap.put(i, new HashMap<>());
						}
						if (!columnDuplicateMap.containsKey(j)) {
							columnDuplicateMap.put(j, new HashMap<>());
						}
						rowDuplicateMap.get(i).put(potentialValue, true);
						columnDuplicateMap.get(j).put(potentialValue, true);


						// recurse
						boolean result = false;
						if (i == j) 
							result = createMatrix(matrix, traceLeft - potentialValue, rowDuplicateMap, columnDuplicateMap, debug + "	", numPlaced+1);
						 else 
							result = createMatrix(matrix, traceLeft, rowDuplicateMap, columnDuplicateMap, debug  + " 	", numPlaced+1);
									
						if (result) 
							return result;

						// undo moves and state changes made
						matrix[i][j] = 0;
						rowDuplicateMap.get(i).remove(potentialValue);
						if (rowDuplicateMap.get(i).size() == 0) {
							rowDuplicateMap.remove(i);
						}
						columnDuplicateMap.get(j).remove(potentialValue);
						if (columnDuplicateMap.get(j).size() == 0) {
							columnDuplicateMap.remove(j);
						}

					} 
				}
			}
		}
					
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String[] line = in.nextLine().trim().split(" ");
          int n = Integer.parseInt(line[0]);
          int k = Integer.parseInt(line[1]);
          Result r = createMatrix(n, k);
          System.out.println("Case #" + i + ": " + (r.status));
          if (r.status.equals("POSSIBLE")) {
          	printMatrix(r.matrix);
          }
        }
	}

	public static void printMatrix(int[][] m) {

		for (int row = 0; row < m.length; row++) {
			for (int col = 0; col < m[row].length - 1; col++) {
				System.out.print(m[row][col] + " ");
			}
			System.out.print(m[row][m[row].length - 1]);
			System.out.println();
		}
	}
	
}