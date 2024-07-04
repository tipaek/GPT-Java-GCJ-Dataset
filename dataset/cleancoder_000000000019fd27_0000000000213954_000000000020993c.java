import java.util.Scanner;

public class Solution {
    public static void solve(int testCaseNumber, int[][] matrix) {
        int trace = 0;
        int rowsWithRepeats = 0;
        int columnsWithRepeats = 0;
        boolean[] columnsThatRepeat = new boolean[matrix.length];
        boolean[] rowsThatRepeat = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowsThatRepeat[i]) {
                    for (int k = j + 1; k < matrix[i].length; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            rowsThatRepeat[i] = true;
                            rowsWithRepeats++;
                            break;
                        }
                    }
                }
                
                if (!columnsThatRepeat[j]) {
                    for (int k2 = i + 1; k2 < matrix.length; k2++) {
                        if (matrix[i][j] == matrix[k2][j]) {
                            columnsThatRepeat[j] = true;
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
        int testCasesAmount = scanner.nextInt();
        for (int i = 0; i < testCasesAmount; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int column = 0; column < matrixSize; column++) {
                    matrix[row][column] = scanner.nextInt();
                }
            }
            solve(i + 1, matrix);
        }
    }
}