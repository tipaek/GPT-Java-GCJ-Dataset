import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        
        for (int test = 0; test < tests; ++test) {
            int nums = scanner.nextInt();
            
            int trace = 0;
            int repeatedRowsCount = 0;
            int repeatedColsCount = 0;
            
            Set<Integer> repeatedRows = new HashSet<>();
            Set<Integer> repeatedCols = new HashSet<>();
            
            List<Set<Integer>> colsSets = new ArrayList<>(Collections.nCopies(nums, null));
            for (int i = 0; i < nums; i++) {
                colsSets.set(i, new HashSet<>());
            }
            
            for (int i = 0; i < nums; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < nums; j++) {
                    int val = scanner.nextInt();
                    if (i == j) trace += val;
                    
                    if (!rowSet.add(val)) {
                        repeatedRows.add(i);
                    }
                    
                    if (!colsSets.get(j).add(val)) {
                        repeatedCols.add(j);
                    }
                }
            }
            
            repeatedRowsCount = repeatedRows.size();
            repeatedColsCount = repeatedCols.size();
            
            System.out.printf("#%d: %d %d %d%n", test + 1, trace, repeatedRowsCount, repeatedColsCount);
        }
    }
}