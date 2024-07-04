import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];

                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 1; j <= n; j++) {
                    rowSet.add(j);
                    columnSet.add(j);
                }

                for (int j = 0; j < n; j++) {
                    if (!rowSet.remove(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (!columnSet.remove(matrix[j][i])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}