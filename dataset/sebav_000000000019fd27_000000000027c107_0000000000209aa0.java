import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        //int t = 1;
        for (int i = 1; i <= t; i++) {
            final int n = in.nextInt();
            final int targetTrace = in.nextInt();
            //final int n = 3;
            //final int targetTrace = 6;
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
        if (count == 1) {
            check();
        } else {
            for (int i = 0; i < count - 1; i++) {
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
            trace += matrix[i][i];
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
        printMatrix();
        throw new RuntimeException();
    }

    private void printMatrix() {
        for (int[] row : matrix) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print(row[n - 1]);
            System.out.println();
        }
    }

    private final int caseIdx;
    private final int n;
    private final int targetTrace;
    private final int[][] matrix;
    private boolean possible = false;

    Solution(int caseIdx, int n, int targetTrace) {
        this.caseIdx = caseIdx;
        this.n = n;
        this.targetTrace = targetTrace;
        matrix = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i - 1][j - 1] = ((i + j) % n) + 1;
            }
        }
    }
}
