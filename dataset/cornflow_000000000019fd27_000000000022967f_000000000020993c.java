import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testNumber = s.nextInt();
        for (int t = 0; t < testNumber; t++) {
            int rowSize = s.nextInt();
            MatrixNumbers matrix = new MatrixNumbers(rowSize);
            for (int r = 0; r < rowSize; r++) {
                for (int c = 0; c < rowSize; c++) {
                    int value = s.nextInt();
                    matrix.addValue(value);
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t + 1, matrix.diagonalSum, 
                    matrix.rowsWithDuplicates.size(),
                    matrix.columnsWithDuplicates.size());
        }
    }
}

class MatrixNumbers {
    int rowSize;
    int diagonalSum;
    int currentRow;
    int currentColumn;
    List<Set<Integer>> rowNumbers;
    List<Set<Integer>> columnNumbers;
    Set<Integer> rowsWithDuplicates = new HashSet<>();
    Set<Integer> columnsWithDuplicates = new HashSet<>();
    
    public MatrixNumbers(int rowSize) {
        this.rowSize = rowSize;
        rowNumbers = new ArrayList<>(rowSize);
        columnNumbers = new ArrayList<>(rowSize);
        for (int i = 0; i < rowSize; i++) {
            rowNumbers.add(new HashSet<Integer>());
            columnNumbers.add(new HashSet<Integer>());
        }
    }
    
    public void addValue(int value) {
        Set<Integer> row = rowNumbers.get(currentRow);
        if (row.contains(value)) {
            rowsWithDuplicates.add(currentRow);
        }
        row.add(value);
        
        Set<Integer> column = columnNumbers.get(currentColumn);
        if (column.contains(value)) {
            columnsWithDuplicates.add(currentColumn);
        }
        column.add(value);
        
        if (currentColumn == currentRow) {
            diagonalSum += value;
        }
        
        currentRow = currentRow + (currentColumn + 1) / rowSize;
        currentColumn = (currentColumn + 1) % rowSize;
    }
}