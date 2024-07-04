import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        for (int i = 0; i < testCases; i++) {
            solution.handleTestCase(scanner, i + 1);
        }
    }

    private void handleTestCase(Scanner scanner, int testCaseNumber) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] skillLevels = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                skillLevels[i][j] = scanner.nextInt();
            }
        }

        int interestLevel = computeTotalInterest(skillLevels, rows, cols);
        System.out.println("Case #" + testCaseNumber + ": " + interestLevel);
    }

    private int computeTotalInterest(int[][] skillLevels, int rows, int cols) {
        int overallInterest = 0;
        
        while (true) {
            double[][] neighborAverages = calculateNeighborAverages(skillLevels, rows, cols);
            Set<int[]> pointsToRemove = new HashSet<>();
            int currentRoundInterest = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (skillLevels[i][j] != 0 && skillLevels[i][j] < neighborAverages[i][j]) {
                        pointsToRemove.add(new int[]{i, j});
                    }
                    currentRoundInterest += skillLevels[i][j];
                }
            }

            overallInterest += currentRoundInterest;
            if (pointsToRemove.isEmpty()) {
                break;
            }

            for (int[] point : pointsToRemove) {
                skillLevels[point[0]][point[1]] = 0;
            }
        }

        return overallInterest;
    }

    private double[][] calculateNeighborAverages(int[][] skillLevels, int rows, int cols) {
        double[][] averages = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                int sum = 0;

                if (i > 0 && skillLevels[i - 1][j] != 0) {
                    sum += skillLevels[i - 1][j];
                    count++;
                }
                if (i < rows - 1 && skillLevels[i + 1][j] != 0) {
                    sum += skillLevels[i + 1][j];
                    count++;
                }
                if (j > 0 && skillLevels[i][j - 1] != 0) {
                    sum += skillLevels[i][j - 1];
                    count++;
                }
                if (j < cols - 1 && skillLevels[i][j + 1] != 0) {
                    sum += skillLevels[i][j + 1];
                    count++;
                }

                averages[i][j] = count == 0 ? 0 : (double) sum / count;
            }
        }

        return averages;
    }
}