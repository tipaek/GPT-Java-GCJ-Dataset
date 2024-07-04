import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static class Trace {
        private final int k;
        private final int r;
        private final int c;

        public Trace(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }

        public int getK() {
            return k;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }

    private static Trace computeTrace(int[][] matrix, int size) {
        int k = 0, r = 0, c = 0;

        for (int i = 0; i < size; i++) {
            k += matrix[i][i];
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    r++;
                    break;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    c++;
                    break;
                }
            }
        }

        return new Trace(k, r, c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Trace trace = computeTrace(matrix, n);
            System.out.printf("Case #%d: %d %d %d\n", t, trace.getK(), trace.getR(), trace.getC());
        }
    }
}