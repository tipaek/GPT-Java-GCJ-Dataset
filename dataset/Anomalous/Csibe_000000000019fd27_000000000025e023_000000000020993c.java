import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int duplicateRowsCount = 0;
            int traceSum = 0;
            List<Set<Integer>> columnSets = new ArrayList<>(matrixSize);
            
            for (int i = 0; i < matrixSize; i++) {
                columnSets.add(new HashSet<>());
            }
            
            int currentDiagonalIndex = 0;
            Set<Integer> currentRowSet = new HashSet<>();
            
            for (int i = 0; i < matrixSize * matrixSize; i++) {
                int value = scanner.nextInt();
                currentRowSet.add(value);
                columnSets.get(i % matrixSize).add(value);
                
                if (i == currentDiagonalIndex * matrixSize + currentDiagonalIndex) {
                    traceSum += value;
                    currentDiagonalIndex++;
                }
                
                if (i % matrixSize == matrixSize - 1) {
                    if (currentRowSet.size() < matrixSize) {
                        duplicateRowsCount++;
                    }
                    currentRowSet.clear();
                }
            }
            
            int duplicateColumnsCount = 0;
            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() < matrixSize) {
                    duplicateColumnsCount++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + traceSum + " " + duplicateRowsCount + " " + duplicateColumnsCount);
        }
        
        scanner.close();
    }
}