import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int[][] matrix = new int[m][m];

            // Reading the matrix
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            // Calculating the trace
            for (int j = 0; j < m; j++) {
                trace += matrix[j][j];
            }

            // Checking for row duplicates
            for (int j = 0; j < m; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Checking for column duplicates
            for (int k = 0; k < m; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < m; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}