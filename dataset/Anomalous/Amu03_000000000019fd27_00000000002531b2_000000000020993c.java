import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int p = 0; p < t; p++) {
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int n = sc.nextInt();
            ArrayList<HashSet<Integer>> columnSets = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (columnSets.size() <= j) {
                        columnSets.add(new HashSet<>());
                    }
                    
                    columnSets.get(j).add(value);
                    rowSet.add(value);
                }
                
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }
            
            for (HashSet<Integer> colSet : columnSets) {
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + (p + 1) + ": " + trace + " " + colDuplicates + " " + rowDuplicates);
        }
    }
}