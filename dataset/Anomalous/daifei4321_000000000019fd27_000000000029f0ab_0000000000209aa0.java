import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] grid = new int[N][N];
            
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    grid[y][x] = 1 + (y + x) % N;
                }
            }
            
            int[] columnSelection = new int[N];
            boolean[] columnUsed = new boolean[N];
            
            if (selectColumns(grid, K, columnSelection, columnUsed, 0, 0)) {
                System.out.println("CASE #" + t + ": POSSIBLE");
                rearrangeGrid(grid, columnSelection);
                printGrid(grid);
            } else {
                System.out.println("CASE #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
    
    private static boolean selectColumns(int[][] grid, int targetSum, int[] columnSelection, boolean[] columnUsed, int row, int currentSum) {
        int N = grid.length;
        
        if (row == N - 1) {
            int requiredValue = targetSum - currentSum;
            int columnIndex = findIndex(grid[row], requiredValue);
            if (columnIndex >= 0 && !columnUsed[columnIndex]) {
                columnSelection[row] = columnIndex;
                return true;
            }
            return false;
        }
        
        for (int c = 0; c < N; c++) {
            if (columnUsed[c]) continue;
            
            int newSum = currentSum + grid[row][c];
            if (newSum <= targetSum) {
                columnSelection[row] = c;
                columnUsed[c] = true;
                
                if (selectColumns(grid, targetSum, columnSelection, columnUsed, row + 1, newSum)) {
                    return true;
                }
                
                columnUsed[c] = false;
            }
        }
        
        return false;
    }
    
    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    private static void rearrangeGrid(int[][] grid, int[] columnSelection) {
        int N = grid.length;
        
        for (int r = 0; r < N; r++) {
            int selectedColumn = columnSelection[r];
            if (selectedColumn != r) {
                for (int r2 = r + 1; r2 < N; r2++) {
                    if (columnSelection[r2] == r) {
                        swapRows(grid, r, r2);
                        columnSelection[r] = r;
                        columnSelection[r2] = selectedColumn;
                        break;
                    }
                }
            }
        }
    }
    
    private static void swapRows(int[][] grid, int row1, int row2) {
        int[] temp = grid[row1];
        grid[row1] = grid[row2];
        grid[row2] = temp;
    }
    
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}