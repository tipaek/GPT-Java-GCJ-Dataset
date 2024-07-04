import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int totalInterest = 0;
            int[][] skillMatrix = new int[rows][columns];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    skillMatrix[i][j] = scanner.nextInt();
                }
            }
            
            boolean continueSimulation = true;
            while (continueSimulation) {
                totalInterest += calculateInterest(skillMatrix);
                continueSimulation = simulateOneRound(skillMatrix);
            }
            
            System.out.println("Case #" + caseNumber + ": " + totalInterest);
        }
    }

    private static boolean simulateOneRound(int[][] skillMatrix) {
        boolean hasChanges = false;
        int rows = skillMatrix.length;
        int columns = skillMatrix[0].length;
        int[][] updatedSkillMatrix = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (skillMatrix[i][j] != 0 && hasHigherMeanNeighbor(i, j, skillMatrix)) {
                    updatedSkillMatrix[i][j] = 0;
                    hasChanges = true;
                } else {
                    updatedSkillMatrix[i][j] = skillMatrix[i][j];
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                skillMatrix[i][j] = updatedSkillMatrix[i][j];
            }
        }
        
        return hasChanges;
    }

    private static boolean hasHigherMeanNeighbor(int row, int col, int[][] skillMatrix) {
        int[] rowOffsets = {-1, 0, 0, 1};
        int[] colOffsets = {0, -1, 1, 0};
        int currentValue = skillMatrix[row][col];
        int neighborCount = 0;
        int neighborSum = 0;
        
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row;
            int newCol = col;
            boolean foundNeighbor = false;
            
            while (!foundNeighbor) {
                newRow += rowOffsets[i];
                newCol += colOffsets[i];
                
                if (newRow < 0 || newCol < 0 || newRow >= skillMatrix.length || newCol >= skillMatrix[0].length) {
                    break;
                }
                
                if (skillMatrix[newRow][newCol] != 0) {
                    neighborCount++;
                    neighborSum += skillMatrix[newRow][newCol];
                    foundNeighbor = true;
                }
            }
        }
        
        return neighborSum > (neighborCount * currentValue);
    }

    private static int calculateInterest(int[][] skillMatrix) {
        int totalInterest = 0;
        
        for (int[] row : skillMatrix) {
            for (int value : row) {
                totalInterest += value;
            }
        }
        
        return totalInterest;
    }
}