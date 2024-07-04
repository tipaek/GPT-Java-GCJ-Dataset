import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        Solution b = new Solution();
        for (int k = 0; k < tc; k++) {
            String[] pair = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(pair[0]);
            int P = Integer.parseInt(pair[1]);
            if (!validate(P, n)) {
                System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
                break;
            }
            int[] trace = b.getTraceNumbers(P, n);
            int[][] matrix = new int[n][n];

            int[] row = new int[n];
            int[] col = new int[n];
            // loop array diagonally to fill
            for (int i = 0; i < n; i++) {
                matrix[i][i] = trace[i];
                b.markRowAndCol(i, i, row, col, trace[i] - 1);
            }


            if (b.buildTile(matrix, 0, 0, n, row, col)) {
                //print matrix
                System.out.println("Case #"+(k+1)+": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
            }
        }
    }

    private static boolean validate(int p, int n) {
        if (p > (n * n))
            return false;
        if (p == (n * n) - 1)
            return false;
        if (p == (n + 1))
            return false;
        if (p < n)
            return false;
        return true;
    }

    int findInitialMax(int p, int n) {
        while (p - n <= n) {
            n--;
        }
        return n;
    }

    private int[] getTraceNumbers(int p, int n) {
        int[] arr = new int[n];
        int max = findInitialMax(p, n);
        int initMax = max;
        int current = p;
        for (int i = 0; i < n; i++) {
            int next = current - max;
            while (next < (n - i - 1)) {
                max--;
                next = current - max;
            }
            if (i == n - 2 && max == initMax && (current != max*2))
                max--;
            current = current - max;
            arr[i] = max;
        }
        return arr;
    }

    public boolean isValid(int[] row, int[] col, int r, int c, int no) {
        if ((row[r] & (1 << no)) == 0 && (col[c] & (1 << no)) == 0)
            return true;

        return false;
    }

    public void markRowAndCol(int r, int c, int[] row, int[] col, int no) {
        row[r] |= (1 << no);
        col[c] |= (1 << no);
    }

    public void unmarkRowAndCol(int r, int c, int[] row, int[] col, int no) {
        row[r] ^= (1 << no);
        col[c] ^= (1 << no);
    }

    boolean buildTile(int matrix[][], int i, int j, int n, int row[], int col[]) {

        if (j == n - 1) {
            i++;
            j = 0;
        } else j++;

        if (i >= n - 1 && j >= n - 1)
            return true;

        if (i == j) j++;
        for (int k = 0; k < n; k++) {
            {
                if (!isValid(row, col, i, j, k))
                    continue;
                int next = k + 1;
                matrix[i][j] = next;
                markRowAndCol(i, j, row, col, next - 1);
                if (buildTile(matrix, i, j, n, row, col))
                    return true;

                matrix[i][j] = 0;
                unmarkRowAndCol(i, j, row, col, next - 1);
            }
        }
        return false;
    }
}
