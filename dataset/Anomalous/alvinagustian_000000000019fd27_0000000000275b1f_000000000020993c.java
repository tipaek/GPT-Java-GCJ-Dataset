import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns in the matrix: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        int[][] transposedMatrix = new int[cols][rows];

        System.out.println("Enter the elements of the matrix:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposedMatrix[col][row] = matrix[row][col];
            }
        }

        System.out.println("Transposed matrix:");
        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(transposedMatrix[row][col] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}