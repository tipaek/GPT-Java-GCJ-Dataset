import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Input Matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Diagonal Addition
            results[k][0] = calculateDiagonalSum(matrix, n);

            // Row Repeat Calculation
            results[k][1] = calculateRowRepeats(matrix, n);

            // Column Repeat Calculation
            results[k][2] = calculateColumnRepeats(matrix, n);

            // Output results for the current test case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }

    private static int calculateRowRepeats(int[][] matrix, int n) {
        int rowRepeats = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasRepeat = false;
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[i][j])) {
                    hasRepeat = true;
                }
            }
            if (hasRepeat) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int calculateColumnRepeats(int[][] matrix, int n) {
        int colRepeats = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasRepeat = false;
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[j][i])) {
                    hasRepeat = true;
                }
            }
            if (hasRepeat) {
                colRepeats++;
            }
        }
        return colRepeats;
    }
}