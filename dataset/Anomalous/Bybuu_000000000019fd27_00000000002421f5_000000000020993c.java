import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            boolean[] colRepeatCheck = new boolean[n];
            HashSet<Integer>[] colSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                colSets[i] = new HashSet<>();
            }
            
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;
                
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt();
                    
                    if (i == j) {
                        trace += num;
                    }
                    
                    if (!rowSet.add(num)) {
                        rowHasRepeat = true;
                    }
                    
                    if (!colSets[j].add(num) && !colRepeatCheck[j]) {
                        colRepeats++;
                        colRepeatCheck[j] = true;
                    }
                }
                
                if (rowHasRepeat) {
                    rowRepeats++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}