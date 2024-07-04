import java.util.*;

public class Que1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] trace = new int[T];
        int[] rows = new int[T];
        int[] cols = new int[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            scanner.nextLine();  // Consume the newline

            for (int j = 0; j < N; j++) {
                String[] tokens = scanner.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(tokens[k]);
                }
            }

            trace[i] = calculateTrace(matrix, N);
            rows[i] = calculateDuplicateRows(matrix, N);
            cols[i] = calculateDuplicateCols(matrix, N);
        }

        printResults(T, trace, rows, cols);
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateDuplicateRows(int[][] matrix, int N) {
        int duplicateRows = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < N) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int calculateDuplicateCols(int[][] matrix, int N) {
        int duplicateCols = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < N) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static void printResults(int T, int[] trace, int[] rows, int[] cols) {
        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace[i], rows[i], cols[i]);
        }
    }
}