import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Matrix matrix = new Matrix(n);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix.addValue(i, j, value);
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t + 1, matrix.getDiagonalSum(), 
                    matrix.getRowsWithDuplicates(), matrix.getColumnsWithDuplicates());
        }
    }
}

class Matrix {
    private int size;
    private int diagonalSum = 0;
    private List<Set<Integer>> rows;
    private List<Set<Integer>> columns;
    private Set<Integer> rowsWithDuplicates = new HashSet<>();
    private Set<Integer> columnsWithDuplicates = new HashSet<>();
    
    public Matrix(int size) {
        this.size = size;
        rows = new ArrayList<>(size);
        columns = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        }
    }
    
    public void addValue(int row, int col, int value) {
        if (!rows.get(row).add(value)) {
            rowsWithDuplicates.add(row);
        }
        
        if (!columns.get(col).add(value)) {
            columnsWithDuplicates.add(col);
        }
        
        if (row == col) {
            diagonalSum += value;
        }
    }
    
    public int getDiagonalSum() {
        return diagonalSum;
    }
    
    public int getRowsWithDuplicates() {
        return rowsWithDuplicates.size();
    }
    
    public int getColumnsWithDuplicates() {
        return columnsWithDuplicates.size();
    }
}