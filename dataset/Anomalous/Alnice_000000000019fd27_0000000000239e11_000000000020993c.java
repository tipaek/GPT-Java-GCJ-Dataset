import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            List<Set<Integer>> columnSets = new ArrayList<>(Collections.nCopies(N, null));
            List<Set<Integer>> rowSets = new ArrayList<>(Collections.nCopies(N, null));
            
            for (int i = 0; i < N; i++) {
                columnSets.set(i, new HashSet<>());
                rowSets.set(i, new HashSet<>());
            }
            
            long trace = 0;
            int duplicateColumns = 0;
            int duplicateRows = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (columnSets.get(j) != null && !columnSets.get(j).add(value)) {
                        duplicateColumns++;
                        columnSets.set(j, null);
                    }
                    
                    if (rowSets.get(i) != null && !rowSets.get(i).add(value)) {
                        duplicateRows++;
                        rowSets.set(i, null);
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}