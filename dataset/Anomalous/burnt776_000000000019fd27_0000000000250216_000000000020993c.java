import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int k = 0; k < testCases; k++) {
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Input the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace of the matrix
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}