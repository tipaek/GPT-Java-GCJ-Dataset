import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Problem[] problems = readProblems();
        for (Problem p : problems) p.solve();
        printResults(problems);
    }

    static Problem[] readProblems() {
        Scanner scan = new Scanner(System.in);
        Problem[] problems = new Problem[scan.nextInt()];
        for (int i = 0; i < problems.length; i++) {
            int n = scan.nextInt();
            int[] matrix = new int[n * n];
            for (int j = 0; j < n * n; j++) matrix[j] = scan.nextInt();
            problems[i] = new Problem(n, matrix);
        }
        return problems;
    }

    static void printResults(Problem[] problems) {
        for (int i = 0; i < problems.length; i++) {
            Problem p = problems[i];
            System.out.println(String.format("Case #%d: %d %d %d", i + 1, p.trace, p.repeatedRows, p.repeatedColumns));
        }
    }

    static class Problem {
        int n;
        int[] matrix;

        int trace;
        int repeatedRows;
        int repeatedColumns;

        Problem(int n, int[] matrix) {
            this.n = n;
            this.matrix = matrix;
        }

        void solve() {
            boolean[] seen = new boolean[n];
            repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(seen, false);
                for (int j = 0; j < n; j++) {
                    int v = matrix[i * n + j];
                    if (seen[v - 1]) {
                        repeatedRows++;
                        break;
                    }
                    else seen[v - 1] = true;
                }
            }
            repeatedColumns = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(seen, false);
                for (int j = 0; j < n; j++) {
                    int v = matrix[j * n + i];
                    if (seen[v - 1]) {
                        repeatedColumns++;
                        break;
                    }
                    else seen[v - 1] = true;
                }
            }
            trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i * n + i];
            }
        }
    }
}
