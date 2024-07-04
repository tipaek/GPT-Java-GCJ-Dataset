import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            List<Set<Integer>> columnSets = new ArrayList<>(matrixSize);
            for (int i = 0; i < matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }
            
            boolean[] columnRepeats = new boolean[matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        rowHasDuplicates = true;
                    }
                    
                    if (!columnSets.get(col).add(value)) {
                        columnRepeats[col] = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    rowRepeats++;
                }
            }
            
            for (boolean colHasDuplicates : columnRepeats) {
                if (colHasDuplicates) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}