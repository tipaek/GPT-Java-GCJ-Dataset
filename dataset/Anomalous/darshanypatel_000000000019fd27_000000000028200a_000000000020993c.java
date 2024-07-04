import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(reader.readLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
            }

            int trace = computeTrace(matrix, N);
            int rows = countDuplicateRows(matrix, N);
            int cols = countDuplicateCols(matrix, N);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rows, cols);
        }
    }

    private static int computeTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int N) {
        int rows = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != N) {
                rows++;
            }
        }
        return rows;
    }

    private static int countDuplicateCols(int[][] matrix, int N) {
        int cols = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < N; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() != N) {
                cols++;
            }
        }
        return cols;
    }
}