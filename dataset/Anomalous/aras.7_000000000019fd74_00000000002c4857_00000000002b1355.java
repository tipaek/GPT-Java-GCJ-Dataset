import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static class Dancer {
        int r, c, score;
        Dancer up, down, left, right;

        Dancer(int r, int c, int score) {
            this.r = r;
            this.c = c;
            this.score = score;
        }

        boolean shouldBeEliminated() {
            int totalScore = 0, neighborCount = 0;
            if (up != null) { totalScore += up.score; neighborCount++; }
            if (down != null) { totalScore += down.score; neighborCount++; }
            if (left != null) { totalScore += left.score; neighborCount++; }
            if (right != null) { totalScore += right.score; neighborCount++; }
            return totalScore > score * neighborCount;
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

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Dancer dancer = new Dancer(i, j, scanner.nextInt());
                    grid[i][j] = dancer;
                    aliveDancers.add(dancer);
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
            boolean eliminationsOccurred = true;

            while (eliminationsOccurred) {
                eliminationsOccurred = false;
                int roundScore = 0;
                boolean[][] toEliminate = new boolean[rows][cols];

                for (Dancer dancer : aliveDancers) {
                    roundScore += dancer.score;
                    if (dancer.shouldBeEliminated()) {
                        toEliminate[dancer.r][dancer.c] = true;
                        eliminationsOccurred = true;
                    }
                }

                totalScore += roundScore;

                Iterator<Dancer> iterator = aliveDancers.iterator();
                while (iterator.hasNext()) {
                    Dancer dancer = iterator.next();
                    if (toEliminate[dancer.r][dancer.c]) {
                        if (dancer.up != null) dancer.up.down = dancer.down;
                        if (dancer.down != null) dancer.down.up = dancer.up;
                        if (dancer.left != null) dancer.left.right = dancer.right;
                        if (dancer.right != null) dancer.right.left = dancer.left;
                        iterator.remove();
                    }
                }
            }

            System.out.printf("Case #%d: %d\n", t, totalScore);
        }
    }
}