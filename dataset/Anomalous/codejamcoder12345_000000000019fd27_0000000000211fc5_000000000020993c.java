import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            List<Set<Integer>> rows = new ArrayList<>(matrixSize);
            List<Set<Integer>> cols = new ArrayList<>(matrixSize);
            boolean[] rowDuplicates = new boolean[matrixSize];
            boolean[] colDuplicates = new boolean[matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int currentValue = scanner.nextInt();
                    
                    if (i == j) {
                        trace += currentValue;
                    }
                    
                    if (!rows.get(i).add(currentValue) && !rowDuplicates[i]) {
                        rowDuplicates[i] = true;
                        duplicateRows++;
                    }
                    
                    if (!cols.get(j).add(currentValue) && !colDuplicates[j]) {
                        colDuplicates[j] = true;
                        duplicateCols++;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateCols);
        }
        
        scanner.close();
    }
}