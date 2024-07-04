import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int m = scanner.nextInt();
            processMatrix(i, m);
        }
    }

    public static void processMatrix(int caseNumber, int size) {
        int[][] matrix = new int[size][size];
        
        // Reading the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating the sum of the diagonal
        int diagonalSum = 0;
        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        // Counting the number of identical elements in the first row
        int rowRepeatCount = 1;
        for (int j = 1; j < size; j++) {
            if (matrix[0][j - 1] == matrix[0][j]) {
                rowRepeatCount++;
            }
        }
        if (rowRepeatCount == 1) {
            rowRepeatCount = 0;
        }

        // Counting the number of identical elements in the first column
        int columnRepeatCount = 1;
        for (int i = 1; i < size; i++) {
            if (matrix[i - 1][0] == matrix[i][0]) {
                columnRepeatCount++;
            }
        }
        if (columnRepeatCount == 1) {
            columnRepeatCount = 0;
        }

        // Printing the result
        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeatCount + " " + columnRepeatCount);
    }
}