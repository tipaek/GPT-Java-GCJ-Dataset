import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();

        for (int i = 0; i < testCaseNumber; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            System.out.println(getLatinSquareResult(matrix, matrixSize, i + 1));
        }

        scanner.close();
    }

    public static String getLatinSquareResult(int[][] matrix, int size, int caseNumber) {
        String result = "Case #" + caseNumber + ": ";
        int rowRepeatCount = 0;
        int colRepeatCount = 0;
        long trace = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeatCount++;
                    break;
                }
            }
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colRepeatCount++;
                    break;
                }
            }
        }

        return result + trace + " " + rowRepeatCount + " " + colRepeatCount;
    }
}