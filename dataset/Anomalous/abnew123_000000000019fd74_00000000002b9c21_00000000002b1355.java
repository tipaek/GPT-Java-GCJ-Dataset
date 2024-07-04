import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            long totalInterest = 0;
            int[][] skills = new int[rows][columns];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    skills[row][col] = scanner.nextInt();
                }
            }

            boolean continueCalculation = true;
            while (continueCalculation) {
                totalInterest += calculateInterest(skills);
                continueCalculation = executeRound(skills);
            }

            System.out.println("Case #" + caseNumber + ": " + totalInterest);
        }
    }

    private static boolean executeRound(int[][] skills) {
        boolean changesMade = false;
        int rows = skills.length;
        int cols = skills[0].length;
        int[][] updatedSkills = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (skills[row][col] != 0 && hasHigherMeanNeighbors(row, col, skills)) {
                    updatedSkills[row][col] = 0;
                    changesMade = true;
                } else {
                    updatedSkills[row][col] = skills[row][col];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            System.arraycopy(updatedSkills[row], 0, skills[row], 0, cols);
        }

        return changesMade;
    }

    private static boolean hasHigherMeanNeighbors(int row, int col, int[][] skills) {
        int[] rowOffsets = {-1, 0, 0, 1};
        int[] colOffsets = {0, -1, 1, 0};
        int cellValue = skills[row][col];
        int neighborCount = 0;
        int neighborSum = 0;

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row;
            int newCol = col;
            boolean foundNeighbor = false;

            while (!foundNeighbor) {
                newRow += rowOffsets[i];
                newCol += colOffsets[i];

                if (newRow >= 0 && newCol >= 0 && newRow < skills.length && newCol < skills[0].length) {
                    if (skills[newRow][newCol] != 0) {
                        neighborCount++;
                        neighborSum += skills[newRow][newCol];
                        foundNeighbor = true;
                    }
                } else {
                    break;
                }
            }
        }

        return neighborSum > (neighborCount * cellValue);
    }

    private static long calculateInterest(int[][] skills) {
        long totalInterest = 0;
        for (int[] row : skills) {
            for (int skill : row) {
                totalInterest += skill;
            }
        }
        return totalInterest;
    }
}