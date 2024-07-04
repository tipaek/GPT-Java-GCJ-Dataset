import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int res = 0;
    private static int k;

    public static void main(String[] args) {
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            solve(i + 1);
        }
    }

    private static void solve(int caseN) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        int distRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqie = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqie.add(matrix[i][j])) {
                    break;
                }
            }
            if (uniqie.size() != n) {
                ++distRows;
            }
        }
        int distColumns = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqie = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqie.add(matrix[j][i])) {
                    break;
                }
            }
            if (uniqie.size() != n) {
                ++distColumns;
            }
        }
        System.out.println("Case #" + caseN + ": " + trace + " " + distRows + " " + distColumns);
    }
}
