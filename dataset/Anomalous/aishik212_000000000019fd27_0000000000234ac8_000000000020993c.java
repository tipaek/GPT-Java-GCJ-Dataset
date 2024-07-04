import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();  // Size of the matrix
            int diagsum = 0;
            int[][] matrix = new int[n][n];
            int rowDuplicates = 0;

            for (int row = 0; row < n; row++) {
                HashMap<Integer, Integer> rowCheck = new HashMap<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < n; col++) {
                    int value = in.nextInt();
                    matrix[row][col] = value;

                    // Sum the diagonal elements
                    if (row == col) {
                        diagsum += value;
                    }

                    // Check for duplicates in the current row
                    if (!rowHasDuplicate && rowCheck.containsKey(value)) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                    rowCheck.put(value, value);
                }
            }

            int colDuplicates = 0;
            for (int col = 0; col < n; col++) {
                HashMap<Integer, Integer> colCheck = new HashMap<>();
                boolean colHasDuplicate = false;

                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];

                    // Check for duplicates in the current column
                    if (!colHasDuplicate && colCheck.containsKey(value)) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                    colCheck.put(value, value);
                }
            }

            System.out.println("Case #" + i + ": " + diagsum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}