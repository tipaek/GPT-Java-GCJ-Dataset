import java.util.Scanner;

public class Solution {
    public static void solve(int testCaseNumber, int[][] matrix) {
        int trace = 0;
        int rowsWithRepeats = 0;
        int columnsWithRepeats = 0;
        boolean[] rowsRepeatFlag = new boolean[matrix.length];
        boolean[] columnsRepeatFlag = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowsRepeatFlag[i]) {
                    for (int k = j + 1; k < matrix[i].length; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            rowsRepeatFlag[i] = true;
                            rowsWithRepeats++;
                            break;
                        }
                    }
                }
                
                if (!columnsRepeatFlag[j]) {
                    for (int k = i + 1; k < matrix.length; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            columnsRepeatFlag[j] = true;
                            columnsWithRepeats++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowsWithRepeats + " " + columnsWithRepeats);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            solve(testCase, matrix);
        }
    }
}