import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int testCases = scanner.nextInt();

        // Process each test case
        for (int testCase = 1; testCase <= testCases; testCase++) {

            // Read matrix size
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read matrix elements
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate trace (k)
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Calculate rows with duplicate elements (r)
            int duplicateRows = 0;
            for (int row = 0; row < size; row++) {
                boolean[] seen = new boolean[size + 1];
                for (int col = 0; col < size; col++) {
                    if (seen[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Calculate columns with duplicate elements (c)
            int duplicateColumns = 0;
            for (int col = 0; col < size; col++) {
                boolean[] seen = new boolean[size + 1];
                for (int row = 0; row < size; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Print the result
            System.out.format("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}