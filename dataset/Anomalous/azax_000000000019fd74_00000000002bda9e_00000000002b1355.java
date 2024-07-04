import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int columns = Integer.parseInt(dimensions[1]);
            
            int[][] dancers = new int[rows][columns];
            for (int row = 0; row < rows; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int col = 0; col < columns; col++) {
                    dancers[row][col] = Integer.parseInt(rowValues[col]);
                }
            }
            
            long result = performSimulation(dancers);
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
        scanner.close();
    }

    private static long performSimulation(int[][] dancers) {
        long totalInterest = 0;
        boolean hasEliminations = true;
        int round = 0;
        
        while (hasEliminations) {
            hasEliminations = processRound(dancers, round + 1);
            round++;
        }
        
        for (int row = 0; row < dancers.length; row++) {
            for (int col = 0; col < dancers[0].length; col++) {
                int value = dancers[row][col];
                if (value < 0) {
                    totalInterest -= value;
                } else {
                    totalInterest += round * value;
                }
            }
        }
        
        return totalInterest;
    }

    private static boolean processRound(int[][] dancers, int round) {
        boolean hasEliminations = false;
        ArrayList<Integer> eliminationList = new ArrayList<>();
        
        for (int row = 0; row < dancers.length; row++) {
            for (int col = 0; col < dancers[0].length; col++) {
                if (dancers[row][col] < 0) continue;
                
                int[] neighbors = findNeighbors(dancers, row, col);
                int validNeighbors = 0;
                long sum = 0;
                
                for (int i = 0; i < neighbors.length; i += 2) {
                    int neighborRow = neighbors[i];
                    int neighborCol = neighbors[i + 1];
                    if (neighborRow != -1) {
                        sum += dancers[neighborRow][neighborCol];
                        validNeighbors++;
                    }
                }
                
                long currentValue = (long) validNeighbors * dancers[row][col];
                if (sum > currentValue) {
                    hasEliminations = true;
                    eliminationList.add(row);
                    eliminationList.add(col);
                }
            }
        }
        
        for (int i = 0; i < eliminationList.size(); i += 2) {
            int row = eliminationList.get(i);
            int col = eliminationList.get(i + 1);
            dancers[row][col] = -round * dancers[row][col];
        }
        
        return hasEliminations;
    }

    private static int[] findNeighbors(int[][] dancers, int row, int col) {
        int[] neighbors = new int[8];
        
        neighbors[0] = findValidNeighbor(dancers, row, col, -1, 0);
        neighbors[1] = col;
        
        neighbors[2] = findValidNeighbor(dancers, row, col, 1, 0);
        neighbors[3] = col;
        
        neighbors[4] = row;
        neighbors[5] = findValidNeighbor(dancers, row, col, 0, -1);
        
        neighbors[6] = row;
        neighbors[7] = findValidNeighbor(dancers, row, col, 0, 1);
        
        return neighbors;
    }

    private static int findValidNeighbor(int[][] dancers, int row, int col, int rowStep, int colStep) {
        int newRow = row + rowStep;
        int newCol = col + colStep;
        
        while (newRow >= 0 && newRow < dancers.length && newCol >= 0 && newCol < dancers[0].length && dancers[newRow][newCol] < 0) {
            newRow += rowStep;
            newCol += colStep;
        }
        
        if (newRow < 0 || newRow >= dancers.length || newCol < 0 || newCol >= dancers[0].length) {
            return -1;
        }
        
        return rowStep != 0 ? newRow : newCol;
    }
}