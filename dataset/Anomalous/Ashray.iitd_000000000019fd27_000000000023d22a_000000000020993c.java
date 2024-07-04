import java.util.*;

class Solution {
    public static List<Integer> calculateMatrixProperties(int[][] matrix, int size) {
        int diagonalSum = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowFlag = false;
            boolean columnFlag = false;
            
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }

                if (!rowSet.add(matrix[i][j])) {
                    if (!rowFlag) {
                        repeatedRows++;
                        rowFlag = true;
                    }
                }

                if (!columnSet.add(matrix[j][i])) {
                    if (!columnFlag) {
                        repeatedColumns++;
                        columnFlag = true;
                    }
                }
            }
        }
        
        result.add(diagonalSum);
        result.add(repeatedRows);
        result.add(repeatedColumns);
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            List<Integer> results = calculateMatrixProperties(matrix, size);
            System.out.printf("Case #%d: %d %d %d%n", t + 1, results.get(0), results.get(1), results.get(2));
        }
        
        scanner.close();
    }
}