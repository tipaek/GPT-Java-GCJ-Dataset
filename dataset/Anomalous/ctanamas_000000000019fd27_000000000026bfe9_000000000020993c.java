import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;

            // Check rows and calculate trace
            for (int i = 0; i < size; i++) {
                boolean[] rowSeen = new boolean[size];
                boolean rowHasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowSeen[matrix[i][j] - 1]) {
                        rowHasDuplicate = true;
                    } else {
                        rowSeen[matrix[i][j] - 1] = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowsWithDuplicates++;
                }
            }

            // Check columns
            for (int j = 0; j < size; j++) {
                boolean[] colSeen = new boolean[size];
                boolean colHasDuplicate = false;
                for (int i = 0; i < size; i++) {
                    if (colSeen[matrix[i][j] - 1]) {
                        colHasDuplicate = true;
                    } else {
                        colSeen[matrix[i][j] - 1] = true;
                    }
                }
                if (colHasDuplicate) {
                    colsWithDuplicates++;
                }
            }

            output.append("Case #").append(caseNum).append(": ").append(trace)
                  .append(" ").append(rowsWithDuplicates).append(" ").append(colsWithDuplicates).append("\n");
        }

        System.out.print(output);
    }
}