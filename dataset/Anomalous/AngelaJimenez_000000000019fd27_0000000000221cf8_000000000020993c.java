import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int testCases = Integer.parseInt(reader.readLine());
            
            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                int n = Integer.parseInt(reader.readLine());
                int[][] matrix = new int[n][n];
                int diagonalSum = 0;
                int repeatedRows = 0;
                int repeatedCols = 0;

                for (int row = 0; row < n; row++) {
                    String[] line = reader.readLine().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(line[col]);
                        if (row == col) {
                            diagonalSum += matrix[row][col];
                        }
                    }
                }

                for (int row = 0; row < n; row++) {
                    if (hasDuplicates(matrix[row])) {
                        repeatedRows++;
                    }
                }

                for (int col = 0; col < n; col++) {
                    if (hasDuplicates(getColumn(matrix, col))) {
                        repeatedCols++;
                    }
                }

                System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}