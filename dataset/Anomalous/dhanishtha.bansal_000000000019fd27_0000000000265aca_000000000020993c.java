import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (testCases > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                String[] values = br.readLine().trim().split(" ");
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, rowDuplicates, colDuplicates);
            testCases--;
            caseNumber++;
        }
    }
}