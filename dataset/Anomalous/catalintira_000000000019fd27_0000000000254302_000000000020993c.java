import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix and calculate the trace
            for (int row = 0; row < n; ++row) {
                boolean[] rowSeen = new boolean[n + 1];
                boolean rowHasDuplicate = false;

                for (int col = 0; col < n; ++col) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (rowSeen[value]) {
                        rowHasDuplicate = true;
                    } else {
                        rowSeen[value] = true;
                    }

                    if (row == col) {
                        trace += value;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int col = 0; col < n; ++col) {
                boolean[] colSeen = new boolean[n + 1];
                boolean colHasDuplicate = false;

                for (int row = 0; row < n; ++row) {
                    int value = matrix[row][col];

                    if (colSeen[value]) {
                        colHasDuplicate = true;
                    } else {
                        colSeen[value] = true;
                    }
                }

                if (colHasDuplicate) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}