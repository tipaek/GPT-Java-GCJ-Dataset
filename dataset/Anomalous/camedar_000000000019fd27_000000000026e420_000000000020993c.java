import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int diagSum = 0, rowsWithDuplicates = 0, colsWithDuplicates = 0;
            
            List<Set<String>> colSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));
            scanner.nextLine();  // Consume the remaining newline
            
            for (int i = 0; i < n; i++) {
                String[] rowElements = scanner.nextLine().split(" ");
                
                // Calculate diagonal sum
                diagSum += Integer.parseInt(rowElements[i]);
                
                // Check for duplicates in the row
                Set<String> rowSet = new HashSet<>(Arrays.asList(rowElements));
                if (rowSet.size() != n) {
                    rowsWithDuplicates++;
                }
                
                // Update column sets
                for (int j = 0; j < n; j++) {
                    colSets.set(j, new HashSet<>(colSets.get(j)));
                    colSets.get(j).add(rowElements[j]);
                }
            }
            
            // Check for duplicates in columns
            for (Set<String> colSet : colSets) {
                if (colSet.size() != n) {
                    colsWithDuplicates++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n", t, diagSum, rowsWithDuplicates, colsWithDuplicates);
        }
    }
}