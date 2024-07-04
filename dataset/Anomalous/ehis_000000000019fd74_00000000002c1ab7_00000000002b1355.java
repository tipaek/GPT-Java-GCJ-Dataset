import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int ks = 1; ks <= T; ks++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] grid = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            solve(ks, r, c, grid);
        }
    }

    public static double averageCompassNeighbors(int[][] grid, int r, int c, int posI, int posJ) {
        int up = 0, down = 0, left = 0, right = 0;
        int originalI = posI, originalJ = posJ;
        int neighborsCount = 0;

        // Up
        while (posI > 0) {
            posI--;
            if (grid[posI][posJ] > 0) {
                up = grid[posI][posJ];
                neighborsCount++;
                break;
            }
        }
        posI = originalI;

        // Down
        while (posI < r - 1) {
            posI++;
            if (grid[posI][posJ] > 0) {
                down = grid[posI][posJ];
                neighborsCount++;
                break;
            }
        }
        posI = originalI;

        // Left
        while (posJ > 0) {
            posJ--;
            if (grid[posI][posJ] > 0) {
                left = grid[posI][posJ];
                neighborsCount++;
                break;
            }
        }
        posJ = originalJ;

        // Right
        while (posJ < c - 1) {
            posJ++;
            if (grid[posI][posJ] > 0) {
                right = grid[posI][posJ];
                neighborsCount++;
                break;
            }
        }

        if (neighborsCount > 0) {
            return (double) (up + down + left + right) / neighborsCount;
        }

        return 0;
    }

    public static void solve(int ks, int r, int c, int[][] grid) {
        int result = 0;
        boolean eliminationPossible = true;

        while (eliminationPossible) {
            int interestLevel = 0;
            int remaining = 0;
            List<Position> eliminations = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] != 0) {
                        interestLevel += grid[i][j];
                        remaining++;
                    }
                }
            }

            int averageSkill = interestLevel / remaining;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] != 0 && grid[i][j] < averageCompassNeighbors(grid, r, c, i, j)) {
                        eliminations.add(new Position(i, j));
                    }
                }
            }

            for (Position pos : eliminations) {
                grid[pos.x][pos.y] = 0;
            }

            if (!eliminations.isEmpty()) {
                result += interestLevel;
            } else {
                result += interestLevel;
                eliminationPossible = false;
            }
        }

        System.out.println("Case #" + ks + ": " + result);
    }
}