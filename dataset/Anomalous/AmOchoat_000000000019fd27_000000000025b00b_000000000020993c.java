import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix;
        try {
            StringBuilder result = new StringBuilder();
            String line = reader.readLine();
            int testCases = Integer.parseInt(line.split(" ")[0]);
            for (int i = 1; i <= testCases; i++) {
                line = reader.readLine();
                int n = Integer.parseInt(line.split(" ")[0]);

                matrix = new int[n][n];
                for (int x = 0; x < n; x++) {
                    line = reader.readLine();
                    String[] row = line.split(" ");
                    for (int c = 0; c < n; c++) {
                        matrix[x][c] = Integer.parseInt(row[c]);
                    }
                }

                // Calculate the diagonal sum
                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += matrix[z][z];
                }

                // Check for duplicate values in rows and columns
                int duplicateRows = 0;
                int duplicateColumns = 0;

                for (int a = 0; a < n; a++) {
                    if (hasDuplicates(matrix[a])) {
                        duplicateRows++;
                    }
                }

                for (int a = 0; a < n; a++) {
                    if (hasColumnDuplicates(matrix, a)) {
                        duplicateColumns++;
                    }
                }

                result.append("Case #").append(i).append(": ").append(diagonalSum).append(" ").append(duplicateColumns).append(" ").append(duplicateRows).append("\n");
            }

            if (result.length() > 0) {
                System.out.print(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int col) {
        boolean[] seen = new boolean[matrix.length + 1];
        for (int[] row : matrix) {
            if (seen[row[col]]) {
                return true;
            }
            seen[row[col]] = true;
        }
        return false;
    }
}