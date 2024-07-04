import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            results[k][0] = calculateDiagonalSum(matrix, n);
            results[k][1] = calculateRowRepeats(matrix, n);
            results[k][2] = calculateColumnRepeats(matrix, n);
        }

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
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int calculateColumnRepeats(int[][] matrix, int n) {
        int columnRepeats = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                columnRepeats++;
            }
        }
        return columnRepeats;
    }
}