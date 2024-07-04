import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int k = 1; k <= testCases; k++) {
            int size = scanner.nextInt();
            int trace = 0, rowCount = 0, colCount = 0;
            int[][] matrix = new int[size][size];
            boolean[] rowCheck = new boolean[size];
            boolean[] colCheck = new boolean[size];

            for (int i = 0; i < size; i++) {
                boolean[] rowSeen = new boolean[size];
                for (int j = 0; j < size; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;

                    if (i == j) {
                        trace += num;
                    }

                    if (rowSeen[num - 1]) {
                        rowCheck[i] = true;
                    }
                    rowSeen[num - 1] = true;
                }
            }

            for (int j = 0; j < size; j++) {
                boolean[] colSeen = new boolean[size];
                for (int i = 0; i < size; i++) {
                    int num = matrix[i][j];
                    if (colSeen[num - 1]) {
                        colCheck[j] = true;
                    }
                    colSeen[num - 1] = true;
                }
            }

            for (boolean row : rowCheck) {
                if (row) rowCount++;
            }

            for (boolean col : colCheck) {
                if (col) colCount++;
            }

            System.out.println("Case #" + k + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}