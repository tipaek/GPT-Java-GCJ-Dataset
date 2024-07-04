import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[n][n];
            Set<Integer>[] rows = new HashSet[n];
            Set<Integer>[] cols = new HashSet[n];

            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rows[i].add(matrix[i][j]);
                    cols[j].add(matrix[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                if (rows[i].size() < n) {
                    rowDuplicates++;
                }
                if (cols[i].size() < n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}