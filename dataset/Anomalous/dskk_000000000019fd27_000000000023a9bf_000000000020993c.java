import java.util.HashSet;
import java.util.Scanner;

public class Que1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] trace = new int[T];
        int[] rows = new int[T];
        int[] cols = new int[T];

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            in.nextLine();  // consume the newline character
            int[][] matrix = new int[N][N];

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

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() < size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() < size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}