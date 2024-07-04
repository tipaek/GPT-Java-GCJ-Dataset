import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T < 1 || T > 100) {
            System.out.println("1 <= T <= 100");
            return;
        }

        List<String> results = new ArrayList<>();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            if (N < 2 || N > 100) {
                System.out.println("2 <= N <= 100");
                return;
            }

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = sc.nextInt();
                    if (value > N) {
                        System.out.println("Input should be in the range of Matrix size N");
                        return;
                    }
                    matrix[i][j] = value;
                }
            }

            int trace = calculateTrace(matrix, N);
            int repeatedRows = countRepeatedRows(matrix, N);
            int repeatedColumns = countRepeatedColumns(matrix, N);

            results.add(String.format("Case #%d: %d %d %d", t, trace, repeatedRows, repeatedColumns));
        }

        results.forEach(System.out::println);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
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