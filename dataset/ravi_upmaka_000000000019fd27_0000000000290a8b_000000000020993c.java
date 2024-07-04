import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int trace = 0;
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            
            for(int i=0; i< n; i++) {
                rowMap.put(i, new HashSet<Integer>());
                colMap.put(i, new HashSet<Integer>());
            }
            
            for (int pos = 0; pos < n * n; pos++) {
                int row = pos / n;
                int col = pos % n;
                int cellValue = sc.nextInt();
                
                if (row == col) {
                    trace += cellValue;
                }
                if (rowMap.containsKey(row)) {
                    if (!rowMap.get(row).contains(cellValue)) {
                        rowMap.get(row).add(cellValue);
                    } else  {
                        rowMap.remove(row);
                    }
                }
                if (colMap.containsKey(col)) {
                    if (!colMap.get(col).contains(cellValue)) {
                        colMap.get(col).add(cellValue);
                    } else  {
                        colMap.remove(col);
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + trace + " "
            + (n - rowMap.size()) + " " + (n - colMap.size()));
        }
    }
}
