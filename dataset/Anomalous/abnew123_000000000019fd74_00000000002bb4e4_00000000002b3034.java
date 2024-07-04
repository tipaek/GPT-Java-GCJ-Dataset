import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long totalInterest = 0;
            int[][] skillMatrix = new int[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    skillMatrix[row][col] = scanner.nextInt();
                }
            }

            boolean hasChanges = true;
            while (hasChanges) {
                totalInterest += calculateInterest(skillMatrix);
                hasChanges = performRound(skillMatrix);
            }

            System.out.println("Case #" + testCase + ": " + totalInterest);
        }
    }

    private static boolean performRound(int[][] skillMatrix) {
        boolean changed = false;
        int rows = skillMatrix.length;
        int cols = skillMatrix[0].length;
        int[][] updatedMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (skillMatrix[row][col] != 0 && hasHigherMeanNeighbors(row, col, skillMatrix)) {
                    updatedMatrix[row][col] = 0;
                    changed = true;
                } else {
                    updatedMatrix[row][col] = skillMatrix[row][col];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                skillMatrix[row][col] = updatedMatrix[row][col];
            }
        }

        return changed;
    }

    private static boolean hasHigherMeanNeighbors(int row, int col, int[][] skillMatrix) {
        int[] deltaX = {-1, 0, 0, 1};
        int[] deltaY = {0, -1, 1, 0};
        int currentValue = skillMatrix[row][col];
        int neighborCount = 0;
        int neighborSum = 0;

        for (int i = 0; i < deltaX.length; i++) {
            int newRow = row, newCol = col;
            while (true) {
                newRow += deltaX[i];
                newCol += deltaY[i];
                if (newRow < 0 || newCol < 0 || newRow >= skillMatrix.length || newCol >= skillMatrix[0].length) {
                    break;
                }
                if (skillMatrix[newRow][newCol] != 0) {
                    neighborCount++;
                    neighborSum += skillMatrix[newRow][newCol];
                    break;
                }
            }
        }
        return neighborSum > (neighborCount * currentValue);
    }

    private static long calculateInterest(int[][] skillMatrix) {
        long total = 0;
        for (int[] row : skillMatrix) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }
}