import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check for repeated values in rows
            int repeatedRows = 0;
            for (int row = 0; row < N; row++) {
                boolean[] seen = new boolean[N];
                for (int col = 0; col < N; col++) {
                    if (seen[matrix[row][col] - 1]) {
                        repeatedRows++;
                        break;
                    }
                    seen[matrix[row][col] - 1] = true;
                }
            }

            // Check for repeated values in columns
            int repeatedColumns = 0;
            for (int col = 0; col < N; col++) {
                boolean[] seen = new boolean[N];
                for (int row = 0; row < N; row++) {
                    if (seen[matrix[row][col] - 1]) {
                        repeatedColumns++;
                        break;
                    }
                    seen[matrix[row][col] - 1] = true;
                }
            }

            // Output the results
            System.out.println("Case #" + currentTest + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
        
        input.close();
    }
}