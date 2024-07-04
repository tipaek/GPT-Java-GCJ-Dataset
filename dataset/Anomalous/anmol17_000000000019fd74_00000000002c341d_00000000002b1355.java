import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            String result = solution.handleTestCase(i + 1, scanner);
            System.out.print(result);
            if (i + 1 != t) {
                System.out.println();
            }
        }
    }

    private String handleTestCase(int caseNumber, Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] skills = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                skills[i][j] = scanner.nextInt();
            }
        }

        return "Case #" + caseNumber + ": " + computeTotalInterest(skills, rows, cols);
    }

    private int computeTotalInterest(int[][] skills, int rows, int cols) {
        int totalInterest = 0;

        while (true) {
            double[][] neighborAverages = calculateNeighborAverages(skills, rows, cols);
            Set<List<Integer>> cellsToRemove = new HashSet<>();
            int currentRoundInterest = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (skills[i][j] != 0 && skills[i][j] < neighborAverages[i][j]) {
                        cellsToRemove.add(Arrays.asList(i, j));
                    }
                    currentRoundInterest += skills[i][j];
                }
            }

            totalInterest += currentRoundInterest;

            if (cellsToRemove.isEmpty()) {
                break;
            }

            for (List<Integer> cell : cellsToRemove) {
                skills[cell.get(0)][cell.get(1)] = 0;
            }
        }

        return totalInterest;
    }

    private double[][] calculateNeighborAverages(int[][] skills, int rows, int cols) {
        double[][] neighborAverages = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (skills[i][j] == 0) {
                    neighborAverages[i][j] = 0;
                    continue;
                }

                int[] neighborCount = {0};
                int left = findNeighbor(skills, i, j, rows, cols, true, -1, neighborCount);
                int right = findNeighbor(skills, i, j, rows, cols, true, 1, neighborCount);
                int up = findNeighbor(skills, i, j, rows, cols, false, -1, neighborCount);
                int down = findNeighbor(skills, i, j, rows, cols, false, 1, neighborCount);

                int totalNeighbors = left + right + up + down;
                neighborAverages[i][j] = neighborCount[0] == 0 ? 0 : (double) totalNeighbors / neighborCount[0];
            }
        }

        return neighborAverages;
    }

    private int findNeighbor(int[][] skills, int i, int j, int rows, int cols, boolean isRow, int direction, int[] neighborCount) {
        if (isRow) {
            while (isWithinBounds(rows, cols, i, j)) {
                i += direction;
                if (isWithinBounds(rows, cols, i, j) && skills[i][j] != 0) {
                    neighborCount[0]++;
                    return skills[i][j];
                }
            }
        } else {
            while (isWithinBounds(rows, cols, i, j)) {
                j += direction;
                if (isWithinBounds(rows, cols, i, j) && skills[i][j] != 0) {
                    neighborCount[0]++;
                    return skills[i][j];
                }
            }
        }
        return 0;
    }

    private boolean isWithinBounds(int rows, int cols, int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}