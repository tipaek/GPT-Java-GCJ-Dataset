import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();
        
        for (int t = 0; t < tCases; t++) {
            int nSize = sc.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            Map<Integer, Integer>[] columns = new Map[nSize];
            
            for (int i = 0; i < nSize; i++) {
                Map<Integer, Integer> row = new HashMap<>();
                
                for (int j = 0; j < nSize; j++) {
                    int value = sc.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (columns[j] == null) {
                        columns[j] = new HashMap<>();
                    }
                    
                    columns[j].put(value, columns[j].getOrDefault(value, 0) + 1);
                    row.put(value, row.getOrDefault(value, 0) + 1);
                }
                
                for (int count : row.values()) {
                    if (count > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            int duplicateColumns = 0;
            for (Map<Integer, Integer> column : columns) {
                for (int count : column.values()) {
                    if (count > 1) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateColumns);
        }
    }
}