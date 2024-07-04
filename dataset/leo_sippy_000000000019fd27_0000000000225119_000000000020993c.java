import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        int t = getT();
        String result = "";
        for (int x = 0; x < t; x++) {
            int grid[][] = getGrid();
                 result = result + "Case #" + (x + 1) + ": " + diagonalTotal(grid) + " " + rowRepeat(grid) + " " + collumRepeat(grid)+"\n";
        }
        System.out.print(result);
    }

    public static int collumRepeat(int[][] grid) {
        int rep = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                for (int xtest = 0; xtest < grid.length; xtest++) {
                    if (xtest != x && grid[x][y] == grid[xtest][y]) {
                        rep++;
                        y = y + 1;
                        x = 0;
                        if (y == grid.length) {
                            return rep;
                        }
                        break;

                    }
                }
            }
        }
        return rep;
    }

    public static int rowRepeat(int[][] grid) {
        int rep = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                for (int ytest = 0; ytest < grid.length; ytest++) {
                    if (ytest != y && grid[x][y] == grid[x][ytest]) {
                        rep++;
                        x = x + 1;
                        y = 0;
                        if (x == grid.length) {
                            return rep;
                        }
                        break;
                    }
                }
            }
        }
        return rep;
    }

    public static int diagonalTotal(int[][] grid) {
        int diag = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (x == y) {
                    diag = grid[x][y] + diag;
                }
            }
        }
        return diag;
    }

    public static int[][] getGrid() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int grid[][] = new int[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                grid[x][y] = in.nextInt();
            }
        }
        return grid;
    }

    public static int getT() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        return t;
    }
}
