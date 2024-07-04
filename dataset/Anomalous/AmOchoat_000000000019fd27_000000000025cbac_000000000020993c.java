import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(bf.readLine().split("")[0]);

            for (int i = 1; i <= cases; i++) {
                int n = Integer.parseInt(bf.readLine().split(" ")[0]);
                int[][] matrix = new int[n][n];

                for (int row = 0; row < n; row++) {
                    String[] rowValues = bf.readLine().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(rowValues[col]);
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
                    int[] columnArray = new int[n];
                    for (int row = 0; row < n; row++) {
                        columnArray[row] = matrix[row][col];
                    }
                    if (hasDuplicates(columnArray)) {
                        duplicateCols++;
                    }
                }

                result.append("Case #").append(i).append(": ").append(diagonalSum).append(" ").append(duplicateCols).append(" ").append(duplicateRows).append("\n");
            }

            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}