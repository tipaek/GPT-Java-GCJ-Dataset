import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");

            // Input matrix size
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Read matrix elements
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += matrix[j][j];
            }

            // Calculate number of rows with duplicate elements
            int rowsWithDuplicates = 0;
            for (int x = 0; x < N; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < N; y++) {
                    if (!rowSet.add(matrix[x][y])) {
                        rowsWithDuplicates++;
                        break;
                    }
                }
            }

            // Calculate number of columns with duplicate elements
            int colsWithDuplicates = 0;
            for (int y = 0; y < N; y++) {
                Set<Integer> colSet = new HashSet<>();
                for (int x = 0; x < N; x++) {
                    if (!colSet.add(matrix[x][y])) {
                        colsWithDuplicates++;
                        break;
                    }
                }
            }

            // Output results
            System.out.println(trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }

        scanner.close();
    }
}