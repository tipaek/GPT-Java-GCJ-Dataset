import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();

                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                    }
                }

                if (colHasDuplicate) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + k + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}