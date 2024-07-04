import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            Set<Integer>[] columnSets = new HashSet[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }
            
            boolean[] columnHasDuplicates = new boolean[matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                boolean[] rowSeen = new boolean[matrixSize];
                boolean rowHasDuplicate = false;
                
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt() - 1;

                    if (rowSeen[value]) {
                        rowHasDuplicate = true;
                    }
                    rowSeen[value] = true;

                    if (columnSets[col].contains(value)) {
                        columnHasDuplicates[col] = true;
                    }
                    columnSets[col].add(value);

                    if (row == col) {
                        trace += (value + 1);
                    }
                }
                
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }
            
            for (boolean hasDuplicate : columnHasDuplicates) {
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}