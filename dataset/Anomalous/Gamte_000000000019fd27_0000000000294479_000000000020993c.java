import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0, col = 0, count = 0; count < n * n; row++) {
                if (row == n) {
                    row = 0;
                    col++;
                }
                matrix[col][row] = scanner.nextInt();
                count++;
            }
            Result result = calculateResult(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, result.diagonalSum, result.repeatedRows, result.repeatedCols);
        }
    }
    
    private static Result calculateResult(int[][] matrix) {
        int n = matrix.length;
        int repeatedRows = 0, repeatedCols = 0, diagonalSum = 0;
        Map<Identifier, ElementSet> elementMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            elementMap.put(new Identifier(Type.ROW, i), new ElementSet());
            elementMap.put(new Identifier(Type.COL, i), new ElementSet());
        }
        
        for (int row = 0, col = 0, count = 0; count < n * n; count++) {
            int value = matrix[col][row];
            Identifier rowId = new Identifier(Type.ROW, col);
            Identifier colId = new Identifier(Type.COL, row);
            
            if (!elementMap.get(rowId).hasDuplicate() && checkAndAdd(elementMap.get(rowId), value)) {
                repeatedRows++;
            }
            if (!elementMap.get(colId).hasDuplicate() && checkAndAdd(elementMap.get(colId), value)) {
                repeatedCols++;
            }
            
            if (row == n - 1) {
                row = 0;
                diagonalSum += matrix[col][col];
                col++;
            } else {
                row++;
            }
        }
        return new Result(repeatedRows, repeatedCols, diagonalSum);
    }
    
    private static boolean checkAndAdd(ElementSet elementSet, int value) {
        Set<Integer> set = elementSet.getSet();
        if (set.contains(value)) {
            elementSet.setDuplicate();
            return true;
        }
        set.add(value);
        return false;
    }
    
    private static class Result {
        private final int repeatedRows;
        private final int repeatedCols;
        private final int diagonalSum;
        
        Result(int repeatedRows, int repeatedCols, int diagonalSum) {
            this.repeatedRows = repeatedRows;
            this.repeatedCols = repeatedCols;
            this.diagonalSum = diagonalSum;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Result other = (Result) obj;
            return repeatedRows == other.repeatedRows &&
                   repeatedCols == other.repeatedCols &&
                   diagonalSum == other.diagonalSum;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(repeatedRows, repeatedCols, diagonalSum);
        }
    }
    
    private static class ElementSet {
        private final Set<Integer> set = new HashSet<>();
        private boolean hasDuplicate = false;
        
        Set<Integer> getSet() {
            return set;
        }
        
        boolean hasDuplicate() {
            return hasDuplicate;
        }
        
        void setDuplicate() {
            this.hasDuplicate = true;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ElementSet other = (ElementSet) obj;
            return hasDuplicate == other.hasDuplicate &&
                   Objects.equals(set, other.set);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(set, hasDuplicate);
        }
    }
    
    private static class Identifier {
        private final Type type;
        private final int id;
        
        Identifier(Type type, int id) {
            this.type = type;
            this.id = id;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Identifier other = (Identifier) obj;
            return id == other.id && type == other.type;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(type, id);
        }
    }
    
    private enum Type {
        ROW, COL
    }
}