import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCaseCount = input.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int sum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            int N = input.nextInt();
            int[][] matrix = new int[N][N];

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < N; i++) {
                sum += matrix[i][i];
            }

            // Check for duplicate values in rows and columns
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != N) {
                    duplicateRows++;
                }
                if (colSet.size() != N) {
                    duplicateCols++;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + t + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}