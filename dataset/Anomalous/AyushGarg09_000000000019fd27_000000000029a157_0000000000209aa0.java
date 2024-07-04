import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int[][] generateMatrix(int size, int trace) {
        int startValue = 0;

        // Determine the start value by checking if trace is a multiple of size
        for (int i = 1; i <= size; i++) {
            if (trace == i * size) {
                startValue = i;
                break;
            }
        }

        // If no valid start value found, return null
        if (startValue == 0) {
            return null;
        }

        int[] initialArray = new int[size];
        int currentValue = startValue;

        // Fill the initial array with values starting from startValue
        for (int i = 0; i < size; i++) {
            initialArray[i] = currentValue;
            currentValue++;
            if (currentValue > size) {
                currentValue = 1;
            }
        }

        int[][] matrix = new int[size][size];
        int k = size;

        // Construct the matrix based on the initial array
        for (int i = 0; i < size; i++) {
            int colIndex = 0;
            int temp = k;

            while (temp < size) {
                matrix[i][colIndex++] = initialArray[temp];
                temp++;
            }

            for (int j = 0; j < k; j++) {
                matrix[i][colIndex++] = initialArray[j];
            }

            k--;
        }

        return matrix;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] resultMatrix = generateMatrix(n, k);
            if (resultMatrix != null) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n - 1; col++) {
                        System.out.print(resultMatrix[row][col] + " ");
                    }
                    System.out.print(resultMatrix[row][n - 1]);
                    if (row != n - 1) {
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            if (caseNumber != testCases) {
                System.out.println();
            }
        }
    }
}