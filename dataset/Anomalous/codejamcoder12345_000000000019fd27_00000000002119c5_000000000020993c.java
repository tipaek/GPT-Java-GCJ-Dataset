import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Set<Integer>[] rowSets = new HashSet[n];
            Set<Integer>[] colSets = new HashSet[n];
            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowSets[i].add(value) && !rowDuplicates[i]) {
                        rowDuplicates[i] = true;
                        duplicateRows++;
                    }
                    
                    if (!colSets[j].add(value) && !colDuplicates[j]) {
                        colDuplicates[j] = true;
                        duplicateCols++;
                    }
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}