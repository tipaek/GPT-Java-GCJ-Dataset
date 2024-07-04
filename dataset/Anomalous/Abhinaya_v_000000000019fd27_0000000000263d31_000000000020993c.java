import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int t = sc.nextInt();
            if (t < 0 || t > 100) {
                throw new IllegalArgumentException("Number of test cases must be between 0 and 100.");
            }

            int[][] results = new int[t][3];

            for (int h = 0; h < t; h++) {
                int n = sc.nextInt();
                if (n <= 1 || n > 100) {
                    throw new IllegalArgumentException("Matrix size must be between 2 and 100.");
                }

                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int value = sc.nextInt();
                        if (value <= 0 || value > n) {
                            throw new IllegalArgumentException("Matrix values must be between 1 and " + n);
                        }
                        matrix[i][j] = value;
                    }
                }

                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }
                results[h][0] = trace;

                int duplicateRows = 0;
                for (int i = 0; i < n; i++) {
                    if (hasDuplicates(matrix[i])) {
                        duplicateRows++;
                    }
                }
                results[h][1] = duplicateRows;

                int duplicateColumns = 0;
                for (int i = 0; i < n; i++) {
                    int[] column = new int[n];
                    for (int j = 0; j < n; j++) {
                        column[j] = matrix[j][i];
                    }
                    if (hasDuplicates(column)) {
                        duplicateColumns++;
                    }
                }
                results[h][2] = duplicateColumns;
            }

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(results[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}