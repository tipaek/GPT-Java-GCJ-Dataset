import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            int[][] grid = new int[r][c];
            long score = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = scan.nextInt();
                    score += grid[i][j];
                }
            }

            boolean isLastRound = false;
            int[][] newGrid = new int[r][c];
            while (!isLastRound) {
                boolean isChanged = false;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (grid[i][j] != 0 && isLTAvg(grid, i, j)) {
                            newGrid[i][j] = 0;
                            isChanged = true;
                        } else {
                            newGrid[i][j] = grid[i][j];
                        }
                    }
                }
                if (isChanged) {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            score += newGrid[i][j];
                        }
                    }
                } else {
                    isLastRound = true;
                }
                grid = newGrid;
            }


            System.out.println("Case #" + test + ": " + score);
        }

    }

    private static boolean isLTAvg(int[][] grid, int r, int c) {
        List<Integer> opponents = new ArrayList<>();
        int opponentUpR = r - 1;
        while (opponentUpR >= 0 && grid[opponentUpR][c] == 0) opponentUpR--;
        if (opponentUpR >= 0) opponents.add(grid[opponentUpR][c]);

        int opponentDownR = r + 1;
        while (opponentDownR < grid.length && grid[opponentDownR][c] == 0) opponentDownR++;
        if (opponentDownR < grid.length) opponents.add(grid[opponentDownR][c]);

        int opponentLeftC = c - 1;
        while (opponentLeftC >= 0 && grid[r][opponentLeftC] == 0) opponentLeftC--;
        if (opponentLeftC >= 0) opponents.add(grid[r][opponentLeftC]);

        int opponentRightC = c + 1;
        while (opponentRightC < grid[0].length && grid[r][opponentRightC] == 0) opponentRightC++;
        if (opponentRightC < grid[0].length) opponents.add(grid[r][opponentRightC]);

        return !opponents.isEmpty() && opponents.stream().reduce(0, Integer::sum) > grid[r][c] * opponents.size();
    }
}
