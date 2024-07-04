import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    private static boolean hasEqualTrace(int[][] matrix, int targetTrace) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return targetTrace == trace;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean isPossible = true;
            String result = "POSSIBLE";
            int[][] matrix = new int[n][n];

            int startValue = n + 1;
            for (int i = 0; i < n; i++) {
                int tempValue = startValue;
                int column = 0;
                while (tempValue <= n) {
                    matrix[i][column] = tempValue;
                    tempValue++;
                    column++;
                }
                for (int j = 1; j < startValue; j++, column++) {
                    matrix[i][column] = j;
                }
                startValue--;
            }

            int rotations = 0;
            for (; rotations < n; rotations++) {
                if (hasEqualTrace(matrix, k)) {
                    break;
                } else {
                    for (int row = 0; row < n; row++) {
                        int firstElement = matrix[row][0];
                        System.arraycopy(matrix[row], 1, matrix[row], 0, n - 1);
                        matrix[row][n - 1] = firstElement;
                    }
                }
            }

            if (rotations == n) {
                isPossible = false;
            }

            if (!isPossible) {
                result = "IMPOSSIBLE";
            }

            System.out.println(String.format("Case #%d: %s", testCase, result));
            if (isPossible) {
                for (int[] row : matrix) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}