import java.util.Scanner;

class Mine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int sum = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix elements
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the diagonal elements
            for (int i = 0; i < matrixSize; i++) {
                sum += matrix[i][i];
            }

            // Printing the result for the current test case
            System.out.println("Case #" + testCase + ": " + sum + "0 0");
        }

        scanner.close();
    }
}