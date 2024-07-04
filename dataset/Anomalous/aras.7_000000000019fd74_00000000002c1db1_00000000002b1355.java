import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static class Dancer {
        int row, col, score;
        Dancer up, down, left, right;

        Dancer(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }

        boolean shouldBeEliminated() {
            int totalScore = 0, neighbourCount = 0;

            if (up != null) {
                totalScore += up.score;
                neighbourCount++;
            }
            if (down != null) {
                totalScore += down.score;
                neighbourCount++;
            }
            if (left != null) {
                totalScore += left.score;
                neighbourCount++;
            }
            if (right != null) {
                totalScore += right.score;
                neighbourCount++;
            }

            if (neighbourCount == 0) return false;
            return (double) totalScore / neighbourCount > score;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            Dancer[][] grid = new Dancer[rows][cols];
            List<Dancer> aliveDancers = new LinkedList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = new Dancer(i, j, scanner.nextInt());
                    aliveDancers.add(grid[i][j]);
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i > 0) grid[i][j].up = grid[i - 1][j];
                    if (i < rows - 1) grid[i][j].down = grid[i + 1][j];
                    if (j > 0) grid[i][j].left = grid[i][j - 1];
                    if (j < cols - 1) grid[i][j].right = grid[i][j + 1];
                }
            }

            int totalScore = 0;
            boolean eliminated;

            do {
                eliminated = false;
                int roundScore = 0;
                Set<Dancer> toEliminate = new HashSet<>();

                for (Dancer dancer : aliveDancers) {
                    roundScore += dancer.score;
                    if (dancer.shouldBeEliminated()) {
                        toEliminate.add(dancer);
                        eliminated = true;
                    }
                }

                for (Dancer dancer : toEliminate) {
                    if (dancer.up != null) dancer.up.down = dancer.down;
                    if (dancer.down != null) dancer.down.up = dancer.up;
                    if (dancer.left != null) dancer.left.right = dancer.right;
                    if (dancer.right != null) dancer.right.left = dancer.left;
                    aliveDancers.remove(dancer);
                }

                totalScore += roundScore;
            } while (eliminated);

            System.out.printf("Case #%d: %d\n", testCase, totalScore);
        }
    }
}