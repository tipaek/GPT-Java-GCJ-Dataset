import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int squareSize = scanner.nextInt();
            int trace = scanner.nextInt();
            int[][] matrix = new int[squareSize][squareSize];
            
            if (trace % squareSize == 0) {
                int traceSum = trace / squareSize;
                
                // Fill diagonal with traceSum
                for (int i = 0; i < squareSize; i++) {
                    matrix[i][i] = traceSum;
                }
                
                // Fill the rest of the matrix
                for (int col = 0; col < squareSize; col++) {
                    boolean past = false;
                    int value = traceSum;
                    
                    for (int row = col; ; row++) {
                        if (row >= squareSize) {
                            row = 0;
                            past = true;
                        }
                        
                        if (matrix[row][col] == traceSum) {
                            if (past) break;
                            continue;
                        }
                        
                        value++;
                        if (value > squareSize) value = 1;
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
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}