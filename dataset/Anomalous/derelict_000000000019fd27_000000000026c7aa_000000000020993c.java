import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;

            String[][] matrix = new String[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.nextLine().split(" ");
                trace += Integer.parseInt(matrix[i][i]);
            }

            for (int i = 0; i < n; i++) {
                Set<String> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatRows++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                Set<String> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        repeatCols++;
                        break;
                    }
                }
            }

            results[t] = "Case #" + (t + 1) + ": " + trace + " " + repeatRows + " " + repeatCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}