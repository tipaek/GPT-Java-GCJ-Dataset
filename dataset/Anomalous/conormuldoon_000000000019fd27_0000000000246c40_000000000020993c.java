import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int n = readInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = readIntArray();
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowsWithDuplicates = countDuplicates(matrix, n, true);
        int columnsWithDuplicates = countDuplicates(matrix, n, false);

        return trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates;
    }

    private int countDuplicates(int[][] matrix, int n, boolean isRow) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (set.contains(value)) {
                    duplicates++;
                    break;
                }
                set.add(value);
            }
        }
        return duplicates;
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}