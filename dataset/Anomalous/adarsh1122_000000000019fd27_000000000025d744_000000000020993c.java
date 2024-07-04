import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
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

            // Print the results for this test case
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
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasRepeat = false;
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
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
        int columnRepeats = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasRepeat = false;
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    hasRepeat = true;
                }
            }
            if (hasRepeat) {
                columnRepeats++;
            }
        }
        return columnRepeats;
    }
}