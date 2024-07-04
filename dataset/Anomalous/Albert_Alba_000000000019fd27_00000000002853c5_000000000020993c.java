import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            System.out.print(trace + " ");

            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }
            System.out.print(rowRepeats + " ");

            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }
            System.out.println(colRepeats);
        }

        scanner.close();
    }
}