import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int sum = 0;
            // Calculating the sum of the diagonal elements
            for (int row = 0; row < size; row++) {
                sum += matrix[row][row];
            }

            System.out.println("Sum of diagonal elements: " + sum);
        }

        scanner.close();
    }
}