import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowCount = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            int colCount = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}