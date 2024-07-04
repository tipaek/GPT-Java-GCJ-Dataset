import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        rowHasDuplicates = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }
            
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicates = false;
                
                for (int i = 0; i < matrixSize; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicates = true;
                    }
                }
                
                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateCols);
        }
        
        scanner.close();
    }
}