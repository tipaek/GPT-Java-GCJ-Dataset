import java.util.Scanner;

public class Vestigium {

    public static boolean check(int[] array, int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < N; j++) {
                int[] column = new int[N];
                for (int i = 0; i < N; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}