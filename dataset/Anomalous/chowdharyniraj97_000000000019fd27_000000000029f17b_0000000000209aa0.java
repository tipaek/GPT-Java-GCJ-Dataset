import java.util.*;

public class Solution {
    private static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            found = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();
            solve(n, trace, caseNumber);

            if (!found) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static void solve(int n, int trace, int caseNumber) {
        int[][] matrix = new int[n][n];
        List<Set<Integer>> columns = new ArrayList<>();
        Set<Integer> row = new HashSet<>();

        for (int i = 0; i < n; i++) {
            columns.add(new HashSet<>());
        }

        fillMatrix(matrix, 0, 0, row, columns, trace, caseNumber, 0);
    }

    private static void fillMatrix(int[][] matrix, int i, int j, Set<Integer> row, List<Set<Integer>> columns, int trace, int caseNumber, int currentTrace) {
        if (j >= matrix.length) {
            i++;
            j = 0;
            row.clear();
        }

        if (i >= matrix.length) {
            if (isTraceEqual(matrix, trace)) {
                found = true;
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] rowMatrix : matrix) {
                    for (int value : rowMatrix) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int z = 1; z <= matrix.length; z++) {
            if (!columns.get(j).contains(z) && !row.contains(z)) {
                matrix[i][j] = z;
                if (i == j) {
                    currentTrace += z;
                    if (currentTrace > trace) {
                        return;
                    }
                }
                row.add(z);
                columns.get(j).add(z);
                fillMatrix(matrix, i, j + 1, row, columns, trace, caseNumber, currentTrace);
                if (found) {
                    return;
                }
                row.remove(z);
                columns.get(j).remove(z);
            }
        }
    }

    private static boolean isTraceEqual(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == trace;
    }
}