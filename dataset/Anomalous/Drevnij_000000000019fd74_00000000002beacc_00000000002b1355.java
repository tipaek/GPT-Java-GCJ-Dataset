import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int[][] floor = new int[rows][columns];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }
            
            int totalScore = 0;
            boolean eliminated = true;
            
            while (eliminated) {
                eliminated = false;
                int[][] newFloor = new int[rows][columns];
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        totalScore += floor[i][j];
                        if (floor[i][j] != 0 && shouldEliminate(floor, i, j)) {
                            newFloor[i][j] = 0;
                            eliminated = true;
                        } else {
                            newFloor[i][j] = floor[i][j];
                        }
                    }
                }
                
                floor = newFloor;
            }
            
            System.out.println("Case #" + testCase + ": " + totalScore);
        }
        
        scanner.close();
    }
    
    private static boolean shouldEliminate(int[][] floor, int r, int c) {
        int up = findNeighbor(floor, r, c, -1, 0);
        int down = findNeighbor(floor, r, c, 1, 0);
        int left = findNeighbor(floor, r, c, 0, -1);
        int right = findNeighbor(floor, r, c, 0, 1);
        
        int partners = (up > 0 ? 1 : 0) + (down > 0 ? 1 : 0) + (left > 0 ? 1 : 0) + (right > 0 ? 1 : 0);
        if (partners == 0) return false;
        
        return (up + down + left + right) > floor[r][c] * partners;
    }
    
    private static int findNeighbor(int[][] floor, int r, int c, int dr, int dc) {
        int rows = floor.length;
        int columns = floor[0].length;
        
        r += dr;
        c += dc;
        
        while (r >= 0 && r < rows && c >= 0 && c < columns) {
            if (floor[r][c] > 0) {
                return floor[r][c];
            }
            r += dr;
            c += dc;
        }
        
        return 0;
    }
}