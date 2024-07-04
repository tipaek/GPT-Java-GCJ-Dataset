import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tt = scan.nextInt();

        for (int t = 1; t <= tt; t++) {
            n = scan.nextInt();
            int k = scan.nextInt();

            int[] diag = new int[n];
            boolean isValid = isValidK(n, k, diag);

            if (!isValid) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i][i] = diag[i];
            }

            TreeSet<Integer>[] rowSets = createRowSets(matrix);
            TreeSet<Integer>[] colSets = createColumnSets(matrix);

            fillMatrix(0, 0, matrix, rowSets, colSets);

            System.out.println("Case #" + t + ": POSSIBLE");
            printMatrix(matrix);
        }
    }

    private static TreeSet<Integer>[] createRowSets(int[][] matrix) {
        TreeSet<Integer>[] rowSets = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            rowSets[i] = new TreeSet<>();
            rowSets[i].add(matrix[i][i]);
        }
        return rowSets;
    }

    private static TreeSet<Integer>[] createColumnSets(int[][] matrix) {
        TreeSet<Integer>[] colSets = new TreeSet[n];
        for (int j = 0; j < n; j++) {
            colSets[j] = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                colSets[j].add(i);
            }
            colSets[j].remove(matrix[j][j]);
        }
        return colSets;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean fillMatrix(int y, int x, int[][] matrix, TreeSet<Integer>[] rowSets, TreeSet<Integer>[] colSets) {
        if (y >= n) return true;
        if (x >= n) return fillMatrix(y + 1, 0, matrix, rowSets, colSets);
        if (y == x) return fillMatrix(y, x + 1, matrix, rowSets, colSets);

        for (int i = 1; i <= n; i++) {
            if (rowSets[y].contains(i) && !colSets[x].contains(i)) {
                rowSets[y].remove(i);
                colSets[x].add(i);

                if (fillMatrix(y, x + 1, matrix, rowSets, colSets)) {
                    matrix[y][x] = i;
                    return true;
                }

                rowSets[y].add(i);
                colSets[x].remove(i);
            }
        }
        return false;
    }

    private static boolean isValidK(int n, int k, int[] diag) {
        Arrays.fill(diag, 1);
        int left = k - n;

        if (left == 0) return true;
        if (left - 1 == 0) return false;
        if (left % n == 0) {
            Arrays.fill(diag, k / n);
            return true;
        }
        if (k == (n * n) - 1) return false;

        diag[n - 2]++;
        left--;

        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(left, (i == n - 2) ? n - 2 : n - 1);
            diag[i] += add;
            left -= add;
            if (left == 0) break;
        }

        int sum = diag[0] + diag[1];
        diag[0] = sum / 2;
        diag[1] = sum / 2;
        if (sum % 2 != 0) diag[1]++;

        if (n > 2 && diag[1] == diag[2] || (n == 3 && diag[0] == diag[1])) return false;

        return true;
    }
}