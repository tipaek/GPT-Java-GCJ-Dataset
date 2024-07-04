import java.util.Scanner;

public class Vestigium {
    private static int sentinel = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] seen = new int[101];

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, N);
            int rowRep = countRowRepetitions(matrix, N, seen);
            int colRep = countColumnRepetitions(matrix, N, seen);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRep + " " + colRep);
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepetitions(int[][] matrix, int N, int[] seen) {
        int rowRep = 0;
        for (int row = 0; row < N; row++) {
            if (hasRepetitions(matrix[row], seen)) {
                rowRep++;
            }
        }
        return rowRep;
    }

    private static int countColumnRepetitions(int[][] matrix, int N, int[] seen) {
        int colRep = 0;
        for (int col = 0; col < N; col++) {
            int[] column = new int[N];
            for (int row = 0; row < N; row++) {
                column[row] = matrix[row][col];
            }
            if (hasRepetitions(column, seen)) {
                colRep++;
            }
        }
        return colRep;
    }

    private static boolean hasRepetitions(int[] array, int[] seen) {
        for (int value : array) {
            if (seen[value] == sentinel) {
                sentinel++;
                return true;
            }
            seen[value] = sentinel;
        }
        sentinel++;
        return false;
    }
}