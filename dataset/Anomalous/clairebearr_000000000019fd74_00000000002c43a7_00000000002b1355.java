import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] grid = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            int interest = 0;

            while (true) {
                boolean change = false;
                int[][] update = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        update[i][j] = grid[i][j];
                        if (grid[i][j] == -1) continue;

                        int neighbors = 0;
                        double sum = 0;
                        interest += grid[i][j];

                        for (int a = 0; a < dx.length; a++) {
                            int x = i + dx[a];
                            int y = j + dy[a];
                            while (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == -1) {
                                x += dx[a];
                                y += dy[a];
                            }
                            if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] == -1) continue;
                            neighbors++;
                            sum += grid[x][y];
                        }

                        if (neighbors > 0 && grid[i][j] < sum / neighbors) {
                            update[i][j] = -1;
                            change = true;
                        }
                    }
                }

                grid = update;

                if (!change) {
                    System.out.println("Case #" + test + ": " + interest);
                    break;
                }
            }
        }
    }
}