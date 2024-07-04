import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = readMatrix(size, scanner);
            analyzeMatrix(matrix, caseNumber);
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean[] rowCheck = new boolean[101];
            boolean[] colCheck = new boolean[101];
            boolean rowRepeated = false;
            boolean colRepeated = false;

            for (int j = 0; j < matrix[i].length; j++) {
                int rowValue = matrix[i][j];
                int colValue = matrix[j][i];

                if (i == j) trace += rowValue;

                if (!rowRepeated && rowCheck[rowValue]) {
                    rowRepeats++;
                    rowRepeated = true;
                }

                if (!colRepeated && colCheck[colValue]) {
                    colRepeats++;
                    colRepeated = true;
                }

                rowCheck[rowValue] = true;
                colCheck[colValue] = true;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}