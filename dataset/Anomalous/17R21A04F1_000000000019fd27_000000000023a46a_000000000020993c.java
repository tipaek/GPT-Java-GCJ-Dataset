import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        double diagonalSum = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows and columns:");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            if (i < columns) {
                diagonalSum += matrix[i][i];
            }
        }

        System.out.println("Sum of diagonal elements: " + diagonalSum);
    }
}