import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                scanner.nextLine();
            }

            int rowDuplicates = countDuplicates(matrix, matrixSize, true);
            int colDuplicates = countDuplicates(matrix, matrixSize, false);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int countDuplicates(int[][] matrix, int size, boolean checkRows) {
        int duplicates = 0;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                int value = checkRows ? matrix[i][j] : matrix[j][i];
                if (seen[value]) {
                    duplicates++;
                    break;
                }
                seen[value] = true;
            }
        }

        return duplicates;
    }
}