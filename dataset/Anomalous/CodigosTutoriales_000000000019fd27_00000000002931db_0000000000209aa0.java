import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int squareSize = scanner.nextInt();
            int[][] matrix = new int[squareSize][squareSize];
            int trace = scanner.nextInt();

            if (trace % squareSize == 0) {
                int traceSum = trace / squareSize;

                for (int i = 0; i < squareSize; i++) {
                    matrix[i][i] = traceSum;
                }

                for (int col = 0; col < squareSize; col++) {
                    int value = traceSum;
                    boolean past = false;

                    for (int row = col; true; row++) {
                        if (row >= squareSize) {
                            row = 0;
                            past = true;
                        }

                        if (matrix[row][col] == traceSum) {
                            if (past) break;
                            continue;
                        }

                        value++;
                        if (value > squareSize) {
                            value = 1;
                        }

                        matrix[row][col] = value;
                    }
                }

                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
                if (matrix.length >= 10 && i < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}