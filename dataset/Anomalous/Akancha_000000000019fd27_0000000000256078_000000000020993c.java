import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];
        int[] rowDuplicates = new int[t];
        int[] colDuplicates = new int[t];

        for (int i = 0; i < t; i++) {
            int dimension = sc.nextInt();
            int[][] matrix = new int[dimension][dimension];
            trace[i] = 0;
            rowDuplicates[i] = 0;
            colDuplicates[i] = 0;

            for (int row = 0; row < dimension; row++) {
                boolean[] rowCheck = new boolean[dimension];
                boolean rowHasDuplicate = false;
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace[i] += matrix[row][col];
                    }
                    if (rowCheck[matrix[row][col] - 1]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[row][col] - 1] = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates[i]++;
                }
            }

            for (int col = 0; col < dimension; col++) {
                boolean[] colCheck = new boolean[dimension];
                boolean colHasDuplicate = false;
                for (int row = 0; row < dimension; row++) {
                    if (colCheck[matrix[row][col] - 1]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[row][col] - 1] = true;
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates[i]++;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
        }
    }
}