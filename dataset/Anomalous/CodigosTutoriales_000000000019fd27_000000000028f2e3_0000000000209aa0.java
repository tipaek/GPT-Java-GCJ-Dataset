import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int squareSize = scanner.nextInt();
            int trace = scanner.nextInt();
            
            if (isPossible(squareSize, trace)) {
                int[][] matrix = generateMatrix(squareSize, trace);
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int squareSize, int trace) {
        return trace <= (squareSize * squareSize) && (trace % squareSize) == 0;
    }

    private static int[][] generateMatrix(int squareSize, int trace) {
        int[][] matrix = new int[squareSize][squareSize];
        int traceSum = trace / squareSize;

        for (int i = 0; i < squareSize; i++) {
            matrix[i][i] = traceSum;
        }

        for (int col = 0; col < squareSize; col++) {
            boolean past = false;
            int value = traceSum;
            for (int row = col; true; row++) {
                if (row >= squareSize) {
                    row = 0;
                    past = true;
                }
                if (matrix[row][col] == traceSum) {
                    if (past) break;
                    continue;
                }
                value = (value % squareSize) + 1;
                matrix[row][col] = value;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}