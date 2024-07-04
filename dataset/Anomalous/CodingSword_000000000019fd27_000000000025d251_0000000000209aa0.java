import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tt = scan.nextInt();

        for (int t = 1; t <= tt; t++) {
            n = scan.nextInt();
            int k = scan.nextInt();

            int[] diag = new int[n];
            boolean isValid = validateK(n, k, diag);

            if (!isValid) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i][i] = diag[i];
            }

            TreeSet<Integer>[] rowSets = new TreeSet[n];
            for (int i = 0; i < n; i++) {
                rowSets[i] = new TreeSet<>();
                rowSets[i].add(matrix[i][i]);
            }

            TreeSet<Integer>[] colSets = new TreeSet[n];
            for (int j = 0; j < n; j++) {
                colSets[j] = new TreeSet<>();
                for (int i = 1; i <= n; i++) {
                    colSets[j].add(i);
                }
                colSets[j].remove(matrix[j][j]);
            }

            fillMatrix(0, 0, matrix, rowSets, colSets);

            System.out.println("Case #" + t + ": POSSIBLE");
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean fillMatrix(int y, int x, int[][] matrix, TreeSet<Integer>[] rowSets, TreeSet<Integer>[] colSets) {
        if (y >= n) {
            return true;
        }

        if (x >= n) {
            return fillMatrix(y + 1, 0, matrix, rowSets, colSets);
        }

        if (y == x) {
            return fillMatrix(y, x + 1, matrix, rowSets, colSets);
        }

        for (int i = 1; i <= n; i++) {
            if (rowSets[y].contains(i) && !colSets[x].contains(i)) {
                rowSets[y].remove(i);
                colSets[x].add(i);

                boolean success = fillMatrix(y, x + 1, matrix, rowSets, colSets);
                if (success) {
                    matrix[y][x] = i;
                    return true;
                }

                rowSets[y].add(i);
                colSets[x].remove(i);
            }
        }

        return false;
    }

    public static boolean validateK(int n, int k, int[] diag) {
        Arrays.fill(diag, 1);
        int remaining = k - n;

        if (remaining == 0) {
            return true;
        }

        if (remaining - 1 == 0 || k == (n * n) - 1) {
            return false;
        }

        if (remaining % n == 0) {
            Arrays.fill(diag, k / n);
            return true;
        }

        diag[n - 2]++;
        remaining--;

        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(remaining, i == n - 2 ? n - 2 : n - 1);
            diag[i] += add;
            remaining -= add;

            if (remaining == 0) {
                break;
            }
        }

        int sum = diag[0] + diag[1];
        diag[0] = sum / 2;
        diag[1] = sum / 2;
        if (sum % 2 != 0) {
            diag[1]++;
        }

        return true;
    }
}