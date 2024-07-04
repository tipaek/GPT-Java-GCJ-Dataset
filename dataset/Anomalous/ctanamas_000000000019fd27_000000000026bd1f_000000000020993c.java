import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int c = 0; c < numCases; c++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowsRep = 0;
            int colsRep = 0;
            boolean[][] colExist = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                boolean[] rowExist = new boolean[size];
                boolean rowHasDuplicates = false;

                for (int j = 0; j < size; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for duplicate values in rows
                    if (rowExist[matrix[i][j] - 1]) {
                        rowHasDuplicates = true;
                    } else {
                        rowExist[matrix[i][j] - 1] = true;
                    }

                    // Track column values
                    colExist[j][matrix[i][j] - 1] = true;
                }

                if (rowHasDuplicates) {
                    rowsRep++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < size; j++) {
                boolean colHasDuplicates = false;
                for (int i = 0; i < size; i++) {
                    if (!colExist[j][i]) {
                        colHasDuplicates = true;
                        break;
                    }
                }
                if (colHasDuplicates) {
                    colsRep++;
                }
            }

            System.out.println("Case #" + (c + 1) + ": " + trace + " " + rowsRep + " " + colsRep);
        }
    }
}