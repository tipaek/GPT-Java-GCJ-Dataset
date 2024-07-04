import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int[] parseTokens(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for (int x = 0; x < n; x++) {
                arr[x] = parseTokens(br.readLine());
            }
            solve(i, arr);
        }
    }

    private static void solve(int caseNumber, int[][] matrix) {
        int n = matrix.length;
        int trace = calculateTrace(matrix, n);
        int rowRepeats = countRowRepeats(matrix, n);
        int colRepeats = countColRepeats(matrix, n);

        System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, rowRepeats, colRepeats));
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < size) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < size) {
                colRepeats++;
            }
        }
        return colRepeats;
    }
}