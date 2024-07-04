import java.util.Scanner;

public class JavaExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        // Read the number of test cases
        int testCases = Integer.parseInt(scanner.next());

        // Read the size of the matrix
        int matrixSize = Integer.parseInt(scanner.next());

        // Initialize the matrix
        int[][] matrix = new int[matrixSize][matrixSize];

        // Process each test case
        while (testCases-- > 0) {
            // Read the matrix elements
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(scanner.next());
                }
            }

            // Calculate the sum of the diagonal elements
            for (int i = 0; i < matrixSize; i++) {
                sum += matrix[i][i];
            }

            // Print the sum
            System.out.println(sum);
        }

        // Close the scanner
        scanner.close();
    }
}