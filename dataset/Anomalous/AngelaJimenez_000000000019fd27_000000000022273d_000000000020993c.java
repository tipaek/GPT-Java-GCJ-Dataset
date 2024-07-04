import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testCases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < testCases; i++) {
                int sumDiagonal = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;
                int n = Integer.parseInt(reader.readLine());

                int[][] matrix = new int[n][n];
                for (int row = 0; row < n; row++) {
                    String[] line = reader.readLine().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(line[col]);
                        if (row == col) {
                            sumDiagonal += matrix[row][col];
                        }
                    }
                }

                for (int k = 0; k < n; k++) {
                    boolean hasDuplicateInRow = false;
                    boolean hasDuplicateInCol = false;
                    for (int z = 0; z < n && (!hasDuplicateInRow || !hasDuplicateInCol); z++) {
                        for (int m = z + 1; m < n && (!hasDuplicateInRow || !hasDuplicateInCol); m++) {
                            if (matrix[k][z] == matrix[k][m]) {
                                hasDuplicateInRow = true;
                            }
                            if (matrix[z][k] == matrix[m][k]) {
                                hasDuplicateInCol = true;
                            }
                        }
                    }
                    if (hasDuplicateInRow) {
                        repeatedRows++;
                    }
                    if (hasDuplicateInCol) {
                        repeatedColumns++;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + sumDiagonal + " " + repeatedRows + " " + repeatedColumns);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}