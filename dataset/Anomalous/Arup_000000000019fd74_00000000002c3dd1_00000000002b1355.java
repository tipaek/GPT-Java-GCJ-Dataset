import java.util.*;

public class Solution {

    private static final int[] DX = {-1, 0, 0, 1};
    private static final int[] DY = {0, -1, 1, 0};

    private static int nR;
    private static int nC;
    private static int[][] grid;
    private static TreeSet<Integer>[] rows;
    private static TreeSet<Integer>[] cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            nR = scanner.nextInt();
            nC = scanner.nextInt();
            grid = new int[nR][nC];
            rows = new TreeSet[nR];
            cols = new TreeSet[nC];

            for (int i = 0; i < nR; i++) {
                rows[i] = new TreeSet<>();
                for (int j = 0; j < nC; j++) {
                    rows[i].add(j);
                }
            }
            for (int i = 0; i < nC; i++) {
                cols[i] = new TreeSet<>();
                for (int j = 0; j < nR; j++) {
                    cols[i].add(j);
                }
            }

            long currentSum = 0;
            for (int i = 0; i < nR; i++) {
                for (int j = 0; j < nC; j++) {
                    grid[i][j] = scanner.nextInt();
                    currentSum += grid[i][j];
                }
            }

            long result = currentSum;

            while (true) {
                long removedSum = processNextRound();
                if (removedSum == 0) break;
                currentSum -= removedSum;
                result += currentSum;
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static long processNextRound() {
        List<Long> toRemove = new ArrayList<>();
        long cost = 0;

        for (int i = 0; i < nR; i++) {
            Iterator<Integer> iterator = rows[i].iterator();
            while (iterator.hasNext()) {
                int col = iterator.next();
                int neighborSum = 0;
                int neighborCount = 0;

                Integer left = rows[i].lower(col);
                if (left != null) {
                    neighborCount++;
                    neighborSum += grid[i][left];
                }
                Integer right = rows[i].higher(col);
                if (right != null) {
                    neighborCount++;
                    neighborSum += grid[i][right];
                }
                Integer up = cols[col].lower(i);
                if (up != null) {
                    neighborCount++;
                    neighborSum += grid[up][col];
                }
                Integer down = cols[col].higher(i);
                if (down != null) {
                    neighborCount++;
                    neighborSum += grid[down][col];
                }

                if (neighborCount * grid[i][col] < neighborSum) {
                    cost += grid[i][col];
                    toRemove.add(100000L * i + col);
                }
            }
        }

        for (Long pos : toRemove) {
            int r = (int) (pos / 100000);
            int c = (int) (pos % 100000);
            rows[r].remove(c);
            cols[c].remove(r);
        }

        return cost;
    }
}