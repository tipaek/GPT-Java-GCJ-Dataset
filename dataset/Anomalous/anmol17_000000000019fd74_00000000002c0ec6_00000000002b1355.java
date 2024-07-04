import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            String result = solution.handleTestCase(i + 1, scanner);
            System.out.print(result);
            if (i < testCases - 1) {
                System.out.println();
            }
        }
    }

    private String handleTestCase(int caseNumber, Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] skillsMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                skillsMatrix[i][j] = scanner.nextInt();
            }
        }

        return "Case #" + caseNumber + ": " + computeTotalInterest(skillsMatrix, rows, cols);
    }

    private int computeTotalInterest(int[][] skillsMatrix, int rows, int cols) {
        int totalInterest = 0;

        while (true) {
            double[][] neighborAverages = calculateNeighborAverages(skillsMatrix, rows, cols);
            Set<List<Integer>> pointsToRemove = new HashSet<>();
            int currentRoundInterest = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (skillsMatrix[i][j] != 0 && skillsMatrix[i][j] < neighborAverages[i][j]) {
                        pointsToRemove.add(Arrays.asList(i, j));
                    }
                    currentRoundInterest += skillsMatrix[i][j];
                }
            }

            totalInterest += currentRoundInterest;

            if (pointsToRemove.isEmpty()) {
                break;
            }

            for (List<Integer> point : pointsToRemove) {
                removePoint(skillsMatrix, point.get(0), point.get(1));
            }
        }

        return totalInterest;
    }

    private void removePoint(int[][] skillsMatrix, int row, int col) {
        skillsMatrix[row][col] = 0;
    }

    private double[][] calculateNeighborAverages(int[][] skillsMatrix, int rows, int cols) {
        double[][] neighborAverages = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] validNeighborsCount = {0};
                int left = fetchNeighborValue(skillsMatrix, i, j, rows, cols, true, -1, validNeighborsCount);
                int right = fetchNeighborValue(skillsMatrix, i, j, rows, cols, true, 1, validNeighborsCount);
                int up = fetchNeighborValue(skillsMatrix, i, j, rows, cols, false, -1, validNeighborsCount);
                int down = fetchNeighborValue(skillsMatrix, i, j, rows, cols, false, 1, validNeighborsCount);

                int totalValue = left + right + up + down;
                neighborAverages[i][j] = validNeighborsCount[0] == 0 ? 0 : totalValue / (double) validNeighborsCount[0];
            }
        }

        return neighborAverages;
    }

    private int fetchNeighborValue(int[][] skillsMatrix, int row, int col, int rows, int cols, boolean isRow, int increment, int[] validNeighborsCount) {
        if (isRow) {
            while (isWithinBounds(rows, cols, row, col)) {
                row += increment;
                if (isWithinBounds(rows, cols, row, col) && skillsMatrix[row][col] != 0) {
                    validNeighborsCount[0]++;
                    return skillsMatrix[row][col];
                }
            }
        } else {
            while (isWithinBounds(rows, cols, row, col)) {
                col += increment;
                if (isWithinBounds(rows, cols, row, col) && skillsMatrix[row][col] != 0) {
                    validNeighborsCount[0]++;
                    return skillsMatrix[row][col];
                }
            }
        }

        return 0;
    }

    private boolean isWithinBounds(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}