import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static final int MAX = 100; 
    static int[][] mat; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= numberOfTestCases; i++) {
            String[] input = br.readLine().split(" ");
            int numberOfRandC = Integer.parseInt(input[0]);
            int sumRequired = Integer.parseInt(input[1]);

            mat = new int[numberOfRandC][numberOfRandC];
            constructMatrix(numberOfRandC);

            int n = 0;
            for (int j = 2; j <= sumRequired; j++) {
                if (sumRequired == (j * numberOfRandC)) {
                    n = j;
                    break;
                }
            }

            if (n != 0) {
                int[][] output = transposeMatrix(numberOfRandC, n);
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(output);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    static void fillRemaining(int i, int j, int n) {
        int x = 2;
        for (int k = i + 1; k < n; k++) {
            mat[k][j] = x++;
        }
        for (int k = 0; k < i; k++) {
            mat[k][j] = x++;
        }
    }

    static void constructMatrix(int n) {
        int right = n - 1, left = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                mat[i][right] = 1;
                fillRemaining(i, right, n);
                right--;
            } else {
                mat[i][left] = 1;
                fillRemaining(i, left, n);
                left++;
            }
        }
    }

    static int[][] transposeMatrix(int numberOfRandC, int n) {
        int[][] output = new int[numberOfRandC][numberOfRandC];
        for (int j = 0; j < numberOfRandC; j++) {
            for (int k = 0; k < numberOfRandC; k++) {
                if (mat[j][k] == n) {
                    for (int l = 0; l < numberOfRandC; l++) {
                        output[l][j] = mat[l][k];
                    }
                    break;
                }
            }
        }
        return output;
    }

    static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(matrix[j][k]);
                if (k < n - 1) {
                    System.out.print(" ");
                }
            }
            if (j < n - 1) {
                System.out.println();
            }
        }
    }
}