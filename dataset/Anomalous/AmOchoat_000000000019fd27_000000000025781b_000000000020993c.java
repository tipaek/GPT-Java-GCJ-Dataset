import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(bf.readLine().trim());

            for (int i = 0; i < cases; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                Integer[][] matrix = new Integer[n][n];

                // Reading the matrix
                for (int row = 0; row < n; row++) {
                    String[] elements = bf.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(elements[col]);
                    }
                }

                // Calculating the diagonal sum
                int diagonalSum = 0;
                for (int j = 0; j < n; j++) {
                    diagonalSum += matrix[j][j];
                }

                // Counting rows with duplicate elements
                int duplicateRows = countDuplicateRows(matrix, n);

                // Counting columns with duplicate elements
                int duplicateCols = countDuplicateColumns(matrix, n);

                result.append("Case #").append(i + 1).append(": ")
                      .append(diagonalSum).append(" ")
                      .append(duplicateRows).append(" ")
                      .append(duplicateCols).append("\n");
            }

            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countDuplicateRows(Integer[][] matrix, int n) {
        int duplicateRows = 0;

        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(Integer[][] matrix, int n) {
        int duplicateCols = 0;

        for (int col = 0; col < n; col++) {
            Integer[] columnArray = new Integer[n];
            for (int row = 0; row < n; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                duplicateCols++;
            }
        }

        return duplicateCols;
    }

    private static boolean hasDuplicates(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}