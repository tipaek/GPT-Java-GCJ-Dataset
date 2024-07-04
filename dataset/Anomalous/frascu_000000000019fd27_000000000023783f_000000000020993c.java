import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        int value = scanner.nextInt();
                        matrix[i][j] = value;
                        rowSet.add(value);
                    }
                    if (rowSet.size() < n) {
                        rowRepeats++;
                    }
                    trace += matrix[i][i];
                }

                for (int j = 0; j < n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        colSet.add(matrix[i][j]);
                    }
                    if (colSet.size() < n) {
                        colRepeats++;
                    }
                }

                System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
        }
    }
}