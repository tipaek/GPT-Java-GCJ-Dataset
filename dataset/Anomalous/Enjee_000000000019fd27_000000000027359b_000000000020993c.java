import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            
            List<Set<Integer>> rowSets = new ArrayList<>(matrixSize);
            List<Set<Integer>> colSets = new ArrayList<>(matrixSize);
            
            for (int i = 0; i < matrixSize; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }
            
            int trace = 0;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    rowSets.get(row).add(value);
                    colSets.get(col).add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
            }
            
            int repeatedRows = 0;
            int repeatedCols = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (rowSets.get(i).size() != matrixSize) {
                    repeatedRows++;
                }
                if (colSets.get(i).size() != matrixSize) {
                    repeatedCols++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
        
        scanner.close();
    }
}