import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            
            boolean[] columnHasDuplicate = new boolean[matrixSize + 1];
            List<Set<Integer>> columnSets = new ArrayList<>();
            
            for (int i = 0; i <= matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }
            
            for (int row = 1; row <= matrixSize; row++) {
                boolean rowAccountedFor = false;
                Set<Integer> rowSet = new HashSet<>();
                
                for (int col = 1; col <= matrixSize; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (!rowAccountedFor) {
                        if (rowSet.contains(value)) {
                            rowDuplicates++;
                            rowAccountedFor = true;
                        } else {
                            rowSet.add(value);
                        }
                    }
                    
                    if (!columnHasDuplicate[col]) {
                        if (columnSets.get(value).contains(col)) {
                            columnHasDuplicate[col] = true;
                            columnSets.get(value).remove(col);
                            columnDuplicates++;
                        } else {
                            columnSets.get(value).add(col);
                        }
                    }
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}