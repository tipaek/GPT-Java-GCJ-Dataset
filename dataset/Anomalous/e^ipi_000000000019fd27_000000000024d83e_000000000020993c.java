import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        
        while (t-- > 0) {
            int N = sc.nextInt();
            int repeatedRows = 0;
            int trace = 0;
            List<Set<Integer>> cols = new ArrayList<>(N);
            
            for (int i = 0; i < N; i++) {
                cols.add(new HashSet<>());
            }
            
            for (int row = 0; row < N; row++) {
                Set<Integer> rowEls = new HashSet<>();
                
                for (int col = 0; col < N; col++) {
                    int el = sc.nextInt();
                    
                    if (col == row) {
                        trace += el;
                    }
                    
                    cols.get(col).add(el);
                    rowEls.add(el);
                }
                
                if (rowEls.size() < N) {
                    repeatedRows++;
                }
            }
            
            int repeatedCols = 0;
            for (Set<Integer> colSet : cols) {
                if (colSet.size() < N) {
                    repeatedCols++;
                }
            }
            
            System.out.println("Case #" + (T - t) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}