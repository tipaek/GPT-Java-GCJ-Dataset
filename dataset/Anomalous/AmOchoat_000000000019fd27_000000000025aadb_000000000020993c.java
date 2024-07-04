import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder result = new StringBuilder();
            String line = bf.readLine();
            int cases = Integer.parseInt(line.trim());
            
            for (int i = 1; i <= cases; i++) {
                line = bf.readLine();
                int n = Integer.parseInt(line.trim());
                int[][] matrix = new int[n][n];
                
                for (int row = 0; row < n; row++) {
                    line = bf.readLine();
                    String[] values = line.split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(values[col]);
                    }
                }

                int diagonalSum = 0;
                for (int j = 0; j < n; j++) {
                    diagonalSum += matrix[j][j];
                }

                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    if (hasDuplicates(matrix[row])) {
                        duplicateRows++;
                    }
                }

                int duplicateCols = 0;
                for (int col = 0; col < n; col++) {
                    if (hasDuplicates(getColumn(matrix, col))) {
                        duplicateCols++;
                    }
                }

                result.append("Case #").append(i).append(": ").append(diagonalSum).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
            }

            System.out.print(result.toString());
        } catch (IOException e) {
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

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }
}