import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            int trace = 0;
            int row = 0;
            int col = 0;

            // Calculate the trace and the number of rows with repeated elements
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        row++;
                        rowHasDuplicate = true;
                    }
                }
            }

            // Calculate the number of columns with repeated elements
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < N; i++) {
                    if (!colHasDuplicate && !colSet.add(matrix[i][j])) {
                        col++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
        }
    }
}