import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Set<Integer>> rowSets = new ArrayList<>(n);
            List<Set<Integer>> colSets = new ArrayList<>(n);
            boolean[] rowDuplicates = new boolean[n];
            boolean[] colDuplicates = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
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
                    
                    if (!rowSets.get(i).add(value) && !rowDuplicates[i]) {
                        rowDuplicates[i] = true;
                        duplicateRows++;
                    }
                    
                    if (!colSets.get(j).add(value) && !colDuplicates[j]) {
                        colDuplicates[j] = true;
                        duplicateCols++;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }
        
        scanner.close();
    }
}