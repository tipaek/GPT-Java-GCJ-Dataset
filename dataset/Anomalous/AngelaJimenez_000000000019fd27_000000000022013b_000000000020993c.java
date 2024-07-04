import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(bf.readLine());
            for (int i = 0; i < cases; i++) {
                int sum = 0;
                int repeatedRows = 0;
                int repeatedCols = 0;
                int n = Integer.parseInt(bf.readLine());
                int[][] matrix = new int[n][n];

                // Reading matrix and calculating diagonal sum
                for (int row = 0; row < n; row++) {
                    String[] line = bf.readLine().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(line[col]);
                        if (row == col) {
                            sum += matrix[row][col];
                        }
                    }
                }

                // Checking for repeated elements in rows and columns
                for (int k = 0; k < n; k++) {
                    boolean hasRepeatedInRow = false;
                    boolean hasRepeatedInCol = false;
                    for (int z = 0; z < n; z++) {
                        for (int m = z + 1; m < n; m++) {
                            if (matrix[k][z] == matrix[k][m]) {
                                hasRepeatedInRow = true;
                            }
                            if (matrix[z][k] == matrix[m][k]) {
                                hasRepeatedInCol = true;
                            }
                        }
                    }
                    if (hasRepeatedInRow) {
                        repeatedRows++;
                    }
                    if (hasRepeatedInCol) {
                        repeatedCols++;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + sum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}