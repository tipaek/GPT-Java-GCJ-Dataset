import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Dancer {
        int row, col, score;
        Dancer up, down, left, right;

        Dancer(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }

        boolean needsElimination() {
            int neighborScoreSum = 0;
            int neighborCount = 0;

            if (up != null) {
                neighborScoreSum += up.score;
                neighborCount++;
            }
            if (down != null) {
                neighborScoreSum += down.score;
                neighborCount++;
            }
            if (left != null) {
                neighborScoreSum += left.score;
                neighborCount++;
            }
            if (right != null) {
                neighborScoreSum += right.score;
                neighborCount++;
            }

            return neighborCount > 0 && neighborScoreSum > score * neighborCount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Dancer[][] grid = new Dancer[rows][cols];
            List<Dancer> aliveDancers = new LinkedList<>();

            // Initialize dancers and grid
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Dancer dancer = new Dancer(i, j, scanner.nextInt());
                    grid[i][j] = dancer;
                    aliveDancers.add(dancer);
                }
            }

            // Set neighbors
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
                Iterator<Dancer> iterator = aliveDancers.iterator();
                Set<Dancer> toEliminate = new HashSet<>();

                // Calculate round score and mark dancers for elimination
                while (iterator.hasNext()) {
                    Dancer dancer = iterator.next();
                    roundScore += dancer.score;
                    if (dancer.needsElimination()) {
                        toEliminate.add(dancer);
                        eliminated = true;
                    }
                }

                totalScore += roundScore;

                // Eliminate marked dancers and update neighbors
                for (Dancer dancer : toEliminate) {
                    if (dancer.up != null) dancer.up.down = dancer.down;
                    if (dancer.down != null) dancer.down.up = dancer.up;
                    if (dancer.left != null) dancer.left.right = dancer.right;
                    if (dancer.right != null) dancer.right.left = dancer.left;
                    aliveDancers.remove(dancer);
                }

            } while (eliminated);

            System.out.printf("Case #%d: %d\n", t, totalScore);
        }
    }
}