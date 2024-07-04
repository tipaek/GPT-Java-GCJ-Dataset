import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        int[][] matrix = new int[100][100];
        int sum = 0;
        int rowDuplicates = 0, colDuplicates = 0;

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();

        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculating the trace of the matrix
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        // Checking for duplicate elements in rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    rowDuplicates++;
                }
                if (matrix[j][i] == matrix[j + 1][i]) {
                    colDuplicates++;
                }
            }
        }

        System.out.print(sum + " ");
        System.out.print(rowDuplicates + " ");
        System.out.println(colDuplicates);
    }
}