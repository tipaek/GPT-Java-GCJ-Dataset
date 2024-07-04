import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int di = scanner.nextInt();
            int[][] grid = new int[di][di];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int row = 0; row < di; row++) {
                for (int col = 0; col < di; col++) {
                    int num = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += num;
                    }
                    grid[row][col] = num;
                }
            }
            
            for (int j = 0; j < di; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int k = 0; k < di; k++) {
                    if (!rowHasDuplicate && rowSet.contains(grid[j][k])) {
                        rowHasDuplicate = true;
                    } else {
                        rowSet.add(grid[j][k]);
                    }
                    
                    if (!colHasDuplicate && colSet.contains(grid[k][j])) {
                        colHasDuplicate = true;
                    } else {
                        colSet.add(grid[k][j]);
                    }
                }
                
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                
                if (colHasDuplicate) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}