import java.io.*;
import java.util.*;

public class Solution {

    static int[][] grid;
    static HashSet<Integer>[] columns;
    static HashSet<Integer>[] rows;
    static int n;
    static boolean done;
    static int k;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            n = sc.nextInt();
            k = sc.nextInt();
            grid = new int[n][n];
            done = false;
            initializeGrid();
            initializeSets();
            dfs(0, 0);
            printResult(test);
        }
    }

    static void initializeGrid() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], -1);
        }
    }

    static void initializeSets() {
        columns = new HashSet[n];
        rows = new HashSet[n];
        for (int i = 0; i < n; i++) {
            columns[i] = new HashSet<>();
            rows[i] = new HashSet<>();
        }
    }

    static void dfs(int i, int j) {
        if (done) return;
        if (j == n) {
            i++;
            j = 0;
            if (i == n) {
                if (isValidSolution()) {
                    done = true;
                }
                return;
            }
        }
        if (grid[i][j] != -1) return;
        for (int num = 1; num <= n; num++) {
            if (isSafe(i, j, num)) {
                placeNumber(i, j, num);
                dfs(i, j + 1);
                if (done) return;
                removeNumber(i, j, num);
            }
        }
    }

    static boolean isValidSolution() {
        int sum = 0;
        for (int x = 0; x < n; x++) {
            sum += grid[x][x];
        }
        return sum == k;
    }

    static boolean isSafe(int i, int j, int num) {
        return !columns[j].contains(num) && !rows[i].contains(num);
    }

    static void placeNumber(int i, int j, int num) {
        grid[i][j] = num;
        rows[i].add(num);
        columns[j].add(num);
    }

    static void removeNumber(int i, int j, int num) {
        grid[i][j] = -1;
        rows[i].remove(num);
        columns[j].remove(num);
    }

    static void printResult(int test) {
        if (done) {
            System.out.println("Case #" + test + ": POSSIBLE");
            for (int[] row : grid) {
                System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
            }
        } else {
            System.out.println("Case #" + test + ": IMPOSSIBLE");
        }
    }
}