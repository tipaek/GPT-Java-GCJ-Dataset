import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            String[] input = reader.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int targetSum = Integer.parseInt(input[1]);

            matrix = new int[size][size];
            constructMatrix(size);

            int multiplier = 0;
            for (int j = 1; j <= targetSum; j++) {
                if (targetSum == (j * size)) {
                    multiplier = j;
                    break;
                }
            }

            if (multiplier != 0) {
                int[][] resultMatrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col] == multiplier) {
                            for (int k = 0; k < size; k++) {
                                resultMatrix[k][row] = matrix[k][col];
                            }
                            break;
                        }
                    }
                }
                System.out.println("Case #" + t + ": POSSIBLE");
                printMatrix(resultMatrix, size);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    static void fillRemaining(int row, int col, int size) {
        int value = 2;
        for (int i = row + 1; i < size; i++) {
            matrix[i][col] = value++;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][col] = value++;
        }
    }

    static void constructMatrix(int size) {
        int right = size - 1, left = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                matrix[i][right] = 1;
                fillRemaining(i, right, size);
                right--;
            } else {
                matrix[i][left] = 1;
                fillRemaining(i, left, size);
                left++;
            }
        }
    }

    static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            if (i < size - 1) {
                System.out.println();
            }
        }
    }
}