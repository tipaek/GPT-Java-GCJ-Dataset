import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int trace = 0;
            int invalidRows = 0;
            int invalidColumns = 0;
            long expectedSum = (dimension * (dimension + 1)) / 2;

            for (int i = 0; i < dimension; i++) {
                int rowSum = 0;
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSum += matrix[i][j];
                }
                trace += matrix[i][i];
                if (rowSum != expectedSum) {
                    invalidRows++;
                }
            }

            for (int j = 0; j < dimension; j++) {
                int columnSum = 0;
                for (int i = 0; i < dimension; i++) {
                    columnSum += matrix[i][j];
                }
                if (columnSum != expectedSum) {
                    invalidColumns++;
                }
            }

            System.out.println("Case #" + testIndex + ": " + trace + " " + invalidRows + " " + invalidColumns);
        }
    }
}