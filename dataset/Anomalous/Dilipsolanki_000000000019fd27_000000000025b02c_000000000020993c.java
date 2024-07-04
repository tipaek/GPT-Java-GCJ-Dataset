import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Input matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            results[k][0] = calculateDiagonalSum(matrix, n);

            // Calculate row repeats
            results[k][1] = calculateRowRepeats(matrix, n);

            // Calculate column repeats
            results[k][2] = calculateColumnRepeats(matrix, n);
        }

        // Print results
        for (int k = 0; k < t; k++) {
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
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }

    private static int calculateColumnRepeats(int[][] matrix, int n) {
        int columnRepeats = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!seen.add(matrix[j][i])) {
                    columnRepeats++;
                    break;
                }
            }
        }
        return columnRepeats;
    }
}