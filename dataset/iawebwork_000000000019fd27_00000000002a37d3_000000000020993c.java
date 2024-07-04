    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCasesCount = Integer.parseInt(in.nextLine());
        
        for (int testCase = 1; testCase <= testCasesCount; testCase++) {
          int trace = 0, repeatedElementsRows = 0, repeatedElementsCols = 0;
				int matrixSize = Integer.parseInt(in.nextLine());

				int[][] matrix = new int[matrixSize][matrixSize];

				for (int row = 0; row < matrixSize; row++) {
					if (in.hasNextLine()) {
						String inputLine = in.nextLine();
						StringTokenizer st = new StringTokenizer(inputLine, " ");
						int col = 0;
						while (st.hasMoreTokens()) {
							matrix[row][col++] = Integer.parseInt(st.nextToken());
							if (col == matrixSize) {
								break;
							}
						}
					}
				}

				for (int row = 0; row < matrixSize; row++) {
					trace += matrix[row][row];

					Set<Integer> rowSet = new HashSet<>();
					Set<Integer> colSet = new HashSet<>();
					int repeatingCol = -1;
					int repeatingRow = -1;

					for (int col = 0; col < matrixSize; col++) {
						if (row > repeatingRow) {
							if (!rowSet.add(matrix[row][col])) {
								repeatingRow = row;
								repeatedElementsRows++;
							}
						}
						if (row > repeatingCol) {
							if (!colSet.add(matrix[col][row])) {
								repeatingCol = row;
								repeatedElementsCols++;
							}
						}
					}
				}

				System.out.println(
						"Case #" + testCase + ": " + trace + " " + repeatedElementsRows + " " + repeatedElementsCols);
        }
      }
    }
