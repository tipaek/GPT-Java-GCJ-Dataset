import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Counting duplicate rows
            int duplicateRows = 0;
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Counting duplicate columns
            int duplicateColumns = 0;
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Output the result
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}