import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static class Result {
        public Result(int trace, int rowsWithRepElems, int colsWithRepElems) {
            this.trace = trace;
            this.rowsWithRepElems = rowsWithRepElems;
            this.colsWithRepElems = colsWithRepElems;
        }
        public int trace;
        public int rowsWithRepElems;
        public int colsWithRepElems;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Result res = solve(matrix, n);
            System.out.println(String.format("Case #%d: %d %d %d", caseNum, res.trace, res.rowsWithRepElems, res.colsWithRepElems));
        }
        scanner.close();
    }

    private static Result solve(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowsWithRepElems = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> elems = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int elem = matrix[i][j];
                if (!elems.contains(elem)) {
                    elems.add(elem);
                } else {
                    rowsWithRepElems++;
                    break;
                }
            }
        }

        int colsWithRepElems = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> elems = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int elem = matrix[i][j];
                if (!elems.contains(elem)) {
                    elems.add(elem);
                } else {
                    colsWithRepElems++;
                    break;
                }
            }
        }

        return new Result(trace, rowsWithRepElems, colsWithRepElems);
    }
}
