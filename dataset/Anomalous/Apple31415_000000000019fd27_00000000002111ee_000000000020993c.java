import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowCount = countDuplicateRows(matrix, size);
            int colCount = countDuplicateCols(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowCount, colCount);
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
        int rowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int colCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }
}