import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] trace = new int[T];
        int[] rows = new int[T];
        int[] cols = new int[T];

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            in.nextLine();

            for (int j = 0; j < N; j++) {
                String[] tokens = in.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(tokens[k]);
                }
            }

            trace[i] = calculateTrace(matrix, N);
            rows[i] = countDuplicateRows(matrix, N);
            cols[i] = countDuplicateCols(matrix, N);
        }

        for (int i = 0; i < T; i++) {
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace[i], rows[i], cols[i]);
        }
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int N) {
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

    private static int countDuplicateCols(int[][] matrix, int N) {
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
}