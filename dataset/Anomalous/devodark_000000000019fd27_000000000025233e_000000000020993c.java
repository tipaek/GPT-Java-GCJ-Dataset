import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int testCaseNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        int trace = 0;
        int rowDuplicates = 0;
        int columnDuplicates = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowCheck = new boolean[matrixSize + 1];
            boolean[] columnCheck = new boolean[matrixSize + 1];

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (columnCheck[matrix[j][i]]) {
                    columnDuplicates++;
                    break;
                } else {
                    columnCheck[matrix[j][i]] = true;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
    }
}