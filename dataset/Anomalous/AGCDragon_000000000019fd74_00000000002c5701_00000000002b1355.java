import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int totalSum = 0;
            int[][] floor = new int[rows][cols];
            
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    floor[row][col] = scanner.nextInt();
                    totalSum += floor[row][col];
                }
            }
            
            int eliminations;
            int roundSum = 0;
            
            do {
                int[][] nextFloor = new int[rows][cols];
                eliminations = 0;
                roundSum = 0;
                
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (floor[row][col] != 0 && floor[row][col] < calculateAverage(row, col, floor)) {
                            eliminations++;
                            nextFloor[row][col] = 0;
                        } else {
                            nextFloor[row][col] = floor[row][col];
                            roundSum += floor[row][col];
                        }
                    }
                }
                
                totalSum += roundSum;
                floor = nextFloor;
            } while (eliminations != 0);
            
            System.out.println("Case #" + testCase + ": " + totalSum);
        }
    }
    
    private static double calculateAverage(int row, int col, int[][] floor) {
        int total = 0;
        int count = 0;
        
        // Check upwards
        for (int i = row - 1; i >= 0; i--) {
            if (floor[i][col] != 0) {
                total += floor[i][col];
                count++;
                break;
            }
        }
        
        // Check downwards
        for (int i = row + 1; i < floor.length; i++) {
            if (floor[i][col] != 0) {
                total += floor[i][col];
                count++;
                break;
            }
        }
        
        // Check leftwards
        for (int i = col - 1; i >= 0; i--) {
            if (floor[row][i] != 0) {
                total += floor[row][i];
                count++;
                break;
            }
        }
        
        // Check rightwards
        for (int i = col + 1; i < floor[0].length; i++) {
            if (floor[row][i] != 0) {
                total += floor[row][i];
                count++;
                break;
            }
        }
        
        return count > 0 ? (double) total / count : 0;
    }
}