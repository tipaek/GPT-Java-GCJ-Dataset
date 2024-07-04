import java.io.*;
import java.util.*;

public class Solution {

    static int[][] grid;
    static HashSet<Integer>[] columns;
    static HashSet<Integer>[] rows;
    static int n;
    static boolean done = false;
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            n = sc.nextInt();
            k = sc.nextInt();
            grid = new int[n][n];
            done = false;
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], -1);
            }
            columns = new HashSet[n];
            rows = new HashSet[n];
            for (int i = 0; i < n; i++) {
                columns[i] = new HashSet<>();
                rows[i] = new HashSet<>();
            }
            dfs(0, 0);
            if (done) {
                System.out.println("Case #" + test + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    StringBuilder str = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        str.append(grid[i][j]).append(" ");
                    }
                    System.out.println(str.toString().trim());
                }
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    static void dfs(int i, int j) {
        if (done) return;
        if (j == n) {
            i++;
            j = 0;
            if (i == n) {
                int sum = 0;
                for (int x = 0; x < n; x++) {
                    sum += grid[x][x];
                }
                if (sum == k) {
                    done = true;
                }
                return;
            }
        }
        if (grid[i][j] != -1) return;
        for (int num = 1; num <= n; num++) {
            if (!columns[j].contains(num) && !rows[i].contains(num)) {
                grid[i][j] = num;
                rows[i].add(num);
                columns[j].add(num);
                dfs(i, j + 1);
                if (done) return;
                rows[i].remove(num);
                columns[j].remove(num);
                grid[i][j] = -1;
            }
        }
    }
}