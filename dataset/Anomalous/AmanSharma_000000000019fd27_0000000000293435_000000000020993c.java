import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();  // Size of the matrix
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            int[][] matrix = new int[n][n];
            boolean[] colHasDuplicate = new boolean[n];

            for (int row = 0; row < n; row++) {
                boolean[] rowHasDuplicate = new boolean[n + 1];
                boolean isRowDuplicate = false;

                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    if (rowHasDuplicate[value]) {
                        isRowDuplicate = true;
                    } else {
                        rowHasDuplicate[value] = true;
                    }

                    if (colHasDuplicate[col]) {
                        continue;
                    }

                    for (int r = 0; r < row; r++) {
                        if (matrix[r][col] == value) {
                            colHasDuplicate[col] = true;
                            colDuplicates++;
                            break;
                        }
                    }
                }

                if (isRowDuplicate) {
                    rowDuplicates++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}