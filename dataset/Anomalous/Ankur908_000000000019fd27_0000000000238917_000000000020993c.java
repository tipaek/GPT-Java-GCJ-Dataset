import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scan.nextInt();

        for (int k = 0; k < testCases; k++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            // Calculate trace and check for repeated elements in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowFlag = false, colFlag = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowFlag = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colFlag = true;
                    }
                }

                if (rowFlag) {
                    rowRepeats++;
                }
                if (colFlag) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scan.close();
    }
}