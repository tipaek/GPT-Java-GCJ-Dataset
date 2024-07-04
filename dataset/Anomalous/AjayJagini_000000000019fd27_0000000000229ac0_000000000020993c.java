import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        int[][] matrix = new int[100][100];
        int sum = 0;
        int rowCount = 0, colCount = 0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Input matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the trace of the matrix (sum of diagonal elements)
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        // Count consecutive equal elements in rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    rowCount++;
                }
                if (matrix[j][i] == matrix[j + 1][i]) {
                    colCount++;
                }
            }
        }

        System.out.print(sum + " ");
        System.out.print(rowCount + " ");
        System.out.println(colCount);
    }
}