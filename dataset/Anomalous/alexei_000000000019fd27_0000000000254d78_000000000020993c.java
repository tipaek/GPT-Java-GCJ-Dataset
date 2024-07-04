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
            int trace = 0;
            
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> columnSets = new ArrayList<>();
            
            for (int i = 0; i < matrixSize; i++) {
                rowSets.add(new HashSet<>());
                columnSets.add(new HashSet<>());
            }
            
            for (int row = 0; row < matrixSize; row++) {
                for (int column = 0; column < matrixSize; column++) {
                    int value = scanner.nextInt();
                    rowSets.get(row).add(value);
                    columnSets.get(column).add(value);
                    if (row == column) {
                        trace += value;
                    }
                }
            }
            
            int duplicateRowCount = 0;
            int duplicateColumnCount = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (rowSets.get(i).size() < matrixSize) {
                    duplicateRowCount++;
                }
                if (columnSets.get(i).size() < matrixSize) {
                    duplicateColumnCount++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRowCount, duplicateColumnCount);
        }
        
        scanner.close();
    }
}