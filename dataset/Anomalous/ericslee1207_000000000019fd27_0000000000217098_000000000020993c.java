import java.util.HashSet;
import java.util.Scanner;

class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int dimension = scanner.nextInt();
            int[][] grid = new int[dimension][dimension];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int row = 0; row < dimension; row++) {
                for (int col = 0; col < dimension; col++) {
                    int num = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += num;
                    }
                    grid[row][col] = num;
                }
            }
            
            for (int j = 0; j < dimension; j++) {
                boolean hasDuplicateRow = false;
                boolean hasDuplicateColumn = false;
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int k = 0; k < dimension; k++) {
                    if (!hasDuplicateRow && !rowSet.add(grid[j][k])) {
                        hasDuplicateRow = true;
                    }
                    if (!hasDuplicateColumn && !colSet.add(grid[k][j])) {
                        hasDuplicateColumn = true;
                    }
                }
                
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
                if (hasDuplicateColumn) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, diagonalSum, duplicateRows, duplicateColumns);
        }
        
        scanner.close();
    }
}