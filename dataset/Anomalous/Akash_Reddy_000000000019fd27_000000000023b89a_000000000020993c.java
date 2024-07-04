import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate trace and row repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                trace += matrix[i][i];
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j]) && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }
                }
            }

            // Calculate column repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i]) && !colFlag) {
                        colRepeats++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
            testCases--;
        }

        // This line seems unnecessary as it reads an extra line after processing all test cases
        // System.out.println(reader.readLine());
    }
}