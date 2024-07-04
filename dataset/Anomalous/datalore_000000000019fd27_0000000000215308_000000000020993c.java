import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * VESTIGIUM
 * Google Code Jam 2020 #1
 * 04/03/20
 */

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt();
            int trace = 0;
            int rowsWithDuplicates = 0;
            int columnsWithDuplicates = 0;
            int[][] matrix = new int[N][N];

            // Read the matrix and calculate the trace
            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = sc.nextInt();
                    rowSet.add(matrix[row][col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                if (rowSet.size() != N) {
                    rowsWithDuplicates++;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != N) {
                    columnsWithDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
    }
}