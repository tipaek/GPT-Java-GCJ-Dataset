import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T && T <= 100; t++) {
            int N = sc.nextInt();
            if (N > 1 && N <= 100) {
                int[][] matrix = new int[N][N];
                fillMatrix(matrix, sc);
                calculateAndPrintResults(matrix, N, t);
            }
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static void calculateAndPrintResults(int[][] matrix, int n, int t) {
        int diagonalSum = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
            if (hasRepeats(matrix[i])) {
                rowRepeats++;
            }
            if (hasRepeats(getColumn(matrix, i))) {
                colRepeats++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, rowRepeats, colRepeats);
    }

    private static boolean hasRepeats(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}