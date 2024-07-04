import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();

                    if (!rowSet.add(matrix[row][col]) && !rowHasDuplicate) {
                        rowRepeatCount++;
                        rowHasDuplicate = true;
                    }

                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col]) && !colHasDuplicate) {
                        colRepeatCount++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeatCount + " " + colRepeatCount);
        }

        sc.close();
    }
}