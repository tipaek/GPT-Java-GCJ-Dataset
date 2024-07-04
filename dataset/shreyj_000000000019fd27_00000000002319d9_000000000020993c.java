import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + findTrace(matrix) + " "
                + findRepeatedNumber(matrix, true) + " "
                + findRepeatedNumber(matrix, false));
        }
    }

    private static int findRepeatedNumber(int[][] matrix, boolean row) {
        int repeated = 0;
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> uniqueNumbers = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                int number = row ? matrix[i][j] : matrix[j][i];
                if (!uniqueNumbers.add(number)) {
                    repeated++;
                    break;
                }
            }
        }
        return repeated;
    }

    private static int findTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}