import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int caseIndex = 0; caseIndex < T; caseIndex++) {
            int N = input.nextInt();
            int sum = 0;
            int rowDupCount = 0;
            int colDupCount = 0;

            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            // Calculate the sum of the main diagonal
            for (int i = 0; i < N; i++) {
                sum += matrix[i][i];
            }

            // Check for duplicate values in each row
            for (int i = 0; i < N; i++) {
                boolean hasDuplicates = false;
                for (int j = 0; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            rowDupCount++;
                            hasDuplicates = true;
                            break;
                        }
                    }
                    if (hasDuplicates) break;
                }
            }

            // Check for duplicate values in each column
            for (int j = 0; j < N; j++) {
                boolean hasDuplicates = false;
                for (int i = 0; i < N - 1; i++) {
                    for (int k = i + 1; k < N; k++) {
                        if (matrix[i][j] == matrix[k][j]) {
                            colDupCount++;
                            hasDuplicates = true;
                            break;
                        }
                    }
                    if (hasDuplicates) break;
                }
            }

            // Print the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, sum, rowDupCount, colDupCount);
        }
    }
}