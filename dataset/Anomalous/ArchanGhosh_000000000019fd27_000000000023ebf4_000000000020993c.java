import java.util.Scanner;

public class TraceCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0, n = 0;

        // Prompt for the number of test cases
        while (true) {
            System.out.println("Enter Test cases between 1 and 100");
            t = sc.nextInt();
            if (t >= 1 && t <= 100) {
                break;
            }
        }

        // Process each test case
        for (int testCase = 1; testCase <= t; testCase++) {
            // Prompt for the matrix size
            while (true) {
                System.out.println("Enter N between 2 and 100");
                n = sc.nextInt();
                if (n >= 2 && n <= 100) {
                    int[][] matrix = new int[n][n];

                    // Fill the matrix with user input
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.println("Enter value at row " + i + " and column " + j + " between 1 and " + n);
                            matrix[i][j] = sc.nextInt();
                        }
                    }

                    int trace = 0, rSame = 0, cSame = 0;

                    // Calculate the trace of the matrix
                    for (int i = 0; i < n; i++) {
                        trace += matrix[i][i];
                    }

                    // Check for duplicate values in rows
                    for (int i = 0; i < n; i++) {
                        if (hasDuplicates(matrix[i])) {
                            rSame++;
                        }
                    }

                    // Check for duplicate values in columns
                    for (int j = 0; j < n; j++) {
                        if (hasDuplicates(getColumn(matrix, j))) {
                            cSame++;
                        }
                    }

                    System.out.println(trace + " " + rSame + " " + cSame);
                    break;
                }
            }
        }
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get a column from a 2D array
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}