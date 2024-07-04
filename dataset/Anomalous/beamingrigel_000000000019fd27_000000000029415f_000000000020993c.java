import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] mat = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                for (int k = 0; k < n; k++) {
                    mat[j][k] = Integer.parseInt(line[k]);
                }
            }

            processMatrix(mat, n, i + 1);
        }

        scanner.close();
    }

    public static void processMatrix(int[][] mat, int n, int caseNumber) {
        int trace = 0, rowCount = 0, colCount = 0;

        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (!rowSet.add(mat[i][j])) {
                    rowCount++;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!colSet.add(mat[j][i])) {
                    colCount++;
                    break;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }
}