import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int h = 0; h < t; h++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            results[h][0] = trace;

            // Counting rows with repeated elements
            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }
            results[h][1] = rowRepeats;

            // Counting columns with repeated elements
            int colRepeats = 0;
            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }
            results[h][2] = colRepeats;
        }

        // Output results
        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
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