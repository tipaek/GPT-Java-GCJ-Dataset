import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                String[] rowInput = bufferedReader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowInput[j]);
                }
                diagonalSum += matrix[i][i];
            }

            int duplicateRowCount = 0;
            int duplicateColCount = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    duplicateRowCount++;
                }
                if (colHasDuplicate) {
                    duplicateColCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRowCount + " " + duplicateColCount);
        }
    }
}