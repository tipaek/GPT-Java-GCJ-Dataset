import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    public void solveCases() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= nCases; i++) {
            solveCase(i, br);
        }
    }

    public void solveCase(int caseNo, BufferedReader br) throws Exception {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        solve(caseNo, n, k);
    }

    private boolean resultPossible;
    private int[][] resultMatrix;

    public void solve(int caseNo, int n, int k) {
        resultPossible = false;
        resultMatrix = null;

        int[][] matrix = new int[n + 1][n + 1];
        Set<Integer>[] rowSets = createSetsArray(n);
        Set<Integer>[] colSets = createSetsArray(n);

        findPossibleTrace(matrix, 1, n, k, rowSets, colSets);

        if (resultPossible) {
            System.out.println("Case #" + caseNo + ": POSSIBLE");
            printMatrix(resultMatrix, n);
        } else {
            System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
        }
    }

    private Set<Integer>[] createSetsArray(int n) {
        Set<Integer>[] sets = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            sets[i] = new HashSet<>();
        }
        return sets;
    }

    private void findPossibleTrace(int[][] matrix, int index, int n, int k, Set<Integer>[] rowSets, Set<Integer>[] colSets) {
        if (resultPossible) return;

        if (index == n) {
            if (k <= n) {
                matrix[index][index] = k;
                rowSets[index].add(k);
                colSets[index].add(k);
                validateMatrix(matrix, 1, 1, n, rowSets, colSets);
                rowSets[index].remove(k);
                colSets[index].remove(k);
            }
            return;
        }

        for (int value = 1; value <= Math.min(k, n); value++) {
            matrix[index][index] = value;
            rowSets[index].add(value);
            colSets[index].add(value);
            findPossibleTrace(matrix, index + 1, n, k - value, rowSets, colSets);
            rowSets[index].remove(value);
            colSets[index].remove(value);
        }
    }

    private void validateMatrix(int[][] matrix, int row, int col, int n, Set<Integer>[] rowSets, Set<Integer>[] colSets) {
        if (resultPossible) return;

        if (row > n) {
            resultPossible = true;
            resultMatrix = cloneMatrix(matrix, n);
            return;
        }

        if (col > n) {
            validateMatrix(matrix, row + 1, 1, n, rowSets, colSets);
            return;
        }

        if (row == col) {
            validateMatrix(matrix, row, col + 1, n, rowSets, colSets);
            return;
        }

        for (int value = 1; value <= n; value++) {
            if (rowSets[row].contains(value) || colSets[col].contains(value)) continue;

            matrix[row][col] = value;
            rowSets[row].add(value);
            colSets[col].add(value);

            validateMatrix(matrix, row, col + 1, n, rowSets, colSets);

            rowSets[row].remove(value);
            colSets[col].remove(value);
        }
    }

    private int[][] cloneMatrix(int[][] matrix, int n) {
        int[][] clonedMatrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            System.arraycopy(matrix[i], 1, clonedMatrix[i], 1, n);
        }
        return clonedMatrix;
    }

    private void printMatrix(int[][] matrix, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == n) {
                    System.out.println(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}