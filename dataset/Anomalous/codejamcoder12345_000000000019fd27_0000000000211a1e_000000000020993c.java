import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int c = 0; c < t; c++) {
            int n = in.nextInt();
            Set<Integer>[] rows = new HashSet[n];
            Set<Integer>[] cols = new HashSet[n];
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }
            
            int trace = 0;
            int numRows = 0;
            int numCols = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = in.nextInt();
                    
                    if (i == j) {
                        trace += cur;
                    }
                    
                    if (!rows[i].add(cur) && !rowFlags[i]) {
                        rowFlags[i] = true;
                        numRows++;
                    }
                    
                    if (!cols[j].add(cur) && !colFlags[j]) {
                        colFlags[j] = true;
                        numCols++;
                    }
                }
            }
            
            System.out.println("Case #" + (c + 1) + ": " + trace + " " + numRows + " " + numCols);
        }
        
        in.close();
    }
}