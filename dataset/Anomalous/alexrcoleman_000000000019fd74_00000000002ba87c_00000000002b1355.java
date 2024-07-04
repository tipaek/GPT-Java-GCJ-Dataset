import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            List<Dancer> changedDancers = new ArrayList<>();
            Dancer[][] grid = new Dancer[rows][cols];
            long totalSkill = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = new Dancer(i, j, scanner.nextInt());
                    changedDancers.add(grid[i][j]);
                    totalSkill += grid[i][j].skill;
                }
            }

            setDancerNeighbors(grid, rows, cols);

            long result = 0;
            while (true) {
                result += totalSkill;
                List<Dancer> toEliminate = new ArrayList<>();
                List<Dancer> nextChangedDancers = new ArrayList<>();

                for (Dancer dancer : changedDancers) {
                    List<Dancer> adjacentDancers = getAdjacentDancers(dancer);
                    if (!isDancerStable(dancer, adjacentDancers)) {
                        toEliminate.add(dancer);
                        nextChangedDancers.addAll(adjacentDancers);
                    }
                }

                if (toEliminate.isEmpty()) break;

                for (Dancer dancer : toEliminate) {
                    totalSkill -= dancer.skill;
                    updateNeighbors(dancer);
                }

                changedDancers = nextChangedDancers;
            }

            System.out.printf("Case #%d: %d%n", t, result);
        }
    }

    private static void setDancerNeighbors(Dancer[][] grid, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) grid[i][j].up = grid[i - 1][j];
                if (i < rows - 1) grid[i][j].down = grid[i + 1][j];
                if (j > 0) grid[i][j].left = grid[i][j - 1];
                if (j < cols - 1) grid[i][j].right = grid[i][j + 1];
            }
        }
    }

    private static boolean isDancerStable(Dancer dancer, List<Dancer> adjacentDancers) {
        long totalAdjacentSkill = adjacentDancers.stream().mapToLong(d -> d.skill).sum();
        return dancer.skill >= totalAdjacentSkill;
    }

    private static List<Dancer> getAdjacentDancers(Dancer dancer) {
        return Arrays.stream(new Dancer[]{dancer.left, dancer.right, dancer.up, dancer.down})
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    private static void updateNeighbors(Dancer dancer) {
        if (dancer.left != null) dancer.left.right = dancer.right;
        if (dancer.right != null) dancer.right.left = dancer.left;
        if (dancer.up != null) dancer.up.down = dancer.down;
        if (dancer.down != null) dancer.down.up = dancer.up;
    }

    static class Dancer {
        int row, col, skill;
        Dancer left, right, up, down;

        Dancer(int row, int col, int skill) {
            this.row = row;
            this.col = col;
            this.skill = skill;
        }
    }
}