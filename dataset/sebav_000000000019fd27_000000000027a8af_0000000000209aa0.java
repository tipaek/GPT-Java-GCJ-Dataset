import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            final int n = in.nextInt();
            final int targetTrace = in.nextInt();
            try {
                new Solution(i, n, targetTrace).solveIt();
            } catch (RuntimeException e) {
                // ignore
            }
        }
    }

    private void solveIt() {
        if (n * n < targetTrace) output();
        solveIt(n);
        output();
    }

    private void solveIt(int count) {
        if (rows.length == 1) {
            check();
        } else {
            for(int i = 0; i < count - 1; i++) {
                solveIt(count - 1);
                if(n % 2 == 0) {
                    swap(i, count - 1);
                } else {
                    swap(0, count - 1);
                }
            }
            solveIt(count - 1);
        }
    }

    private void swap(int a, int b) {
        int[] tmp = matrix[a];
        matrix[a] = matrix[b];
        matrix[b] = tmp;
    }

    private void check() {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += permutatedMatrix[i][i];
        }
        if (trace == targetTrace) {
            possible = true;
            output();
        }
    }

    private void output() {
        if (!possible) {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", caseIdx));
            throw new RuntimeException();
        }
        System.out.println(String.format("Case #%d: POSSIBLE", caseIdx));
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length - 1; j++) {
                System.out.println(ints[j]);
            }
            System.out.println();
        }
        throw new RuntimeException();
    }

    private final int caseIdx;
    private final int n;
    private final int targetTrace;
    private final int[][] matrix;
    private int[][] permutatedMatrix;
    private int[] rows;
    private boolean possible = false;
    private long attemptsCount = 0;

    Solution(int caseIdx, int n, int targetTrace) {
        this.caseIdx = caseIdx;
        this.n = n;
        this.targetTrace = targetTrace;
        matrix = new int[n][n];
        this.rows = new int[n];
        for (int i = 0; i < n; i++) {
            rows[i] = i;
        }
    }
}
