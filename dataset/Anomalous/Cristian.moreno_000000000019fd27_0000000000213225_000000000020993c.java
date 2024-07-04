import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= cases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int row = 0; row < n; row++) {
                String[] line = reader.readLine().split(" ");
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;

                for (int col = 0; col < n; col++) {
                    int value = Integer.parseInt(line[col]);
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }
                    if (!rowCheck[value]) {
                        rowCheck[value] = true;
                    } else {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;

                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    if (!colCheck[value]) {
                        colCheck[value] = true;
                    } else {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}