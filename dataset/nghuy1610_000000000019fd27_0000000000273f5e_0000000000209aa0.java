
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static boolean possibleToAssign(int[][] mat, int x, int y, int val, int n) {
        for (int i = 0; i < n; i++) {
            if (mat[x][i] == val || mat[i][y] == val) {
                return false;
            }
        }
        return true;
    }

    static boolean fillCell(int[][] mat, int x, int y, int n) {
        if (x >= n || y >= n) {
            return true;
        }
        if (mat[x][y] != 0) {
            int nx = x, ny = y + 1;
            if (ny >= n) {
                ny = 0; nx++;
            }
            return fillCell(mat, nx, ny, n);
        }
        boolean isAssigned;
        for (int val = 1; val <= n; val++) {
            if (possibleToAssign(mat, x, y, val, n)) {
                mat[x][y] = val;
                int nx = x, ny = y + 1;
                if (ny >= n) {
                    ny = 0; nx++;
                }
                isAssigned = fillCell(mat, nx, ny, n);
                if (isAssigned) {
                    return isAssigned;
                } else {
                    mat[x][y] = 0;
                }
            }
        }
        return false;
    }

    static String buildMatrix(int[][] mat, int n, int k) {
        int[] init = new int[n];
        int nk = k / n;
        int rk = k % n;
        for (int i = 0; i < n; i++) {
            init[i] = nk;
        }
        if (rk == 1 || rk == n - 1) {
            if (nk == 1 || nk == n - 1) {return "IMPOSSIBLE";}
            else {
                init[0]--;
                init[1]++;
                int j = 2;
                while (rk > 0) {
                    init[j]++;
                    rk--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            mat[i][i] = init[i];
        }
        boolean rs = fillCell(mat, 0, 0, n);
        if (rs) {
            return "POSSIBLE";
        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nRound = scanner.nextInt();
        for (int i =  0; i < nRound; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            String rs = buildMatrix(matrix, n, k);
            System.out.printf("Case #%d: %s\n", i+1, rs);
            if (rs.equals("POSSIBLE")) {
                StringBuilder sb;
                for(int[] row : matrix) {
                    sb = new StringBuilder();
                    for (int cell : row) {
                        sb.append(cell + " ");
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}
