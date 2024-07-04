import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int tc = 1; tc <= t; ++tc) {
            int trace = 0;
            int n = in.nextInt();
            in.nextLine(); // Consume the remaining newline
            
            Set<Integer>[] rowsUniqueValues = new HashSet[n];
            Set<Integer>[] columnsUniqueValues = new HashSet[n];
            
            for (int i = 0; i < n; i++) {
                rowsUniqueValues[i] = new HashSet<>();
                columnsUniqueValues[i] = new HashSet<>();
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int v = in.nextInt();
                    rowsUniqueValues[i].add(v);
                    columnsUniqueValues[j].add(v);
                    if (i == j) {
                        trace += v;
                    }
                }
            }
            
            int repeatedElementsRows = 0;
            int repeatedElementsColumns = 0;
            
            for (int i = 0; i < n; i++) {
                if (rowsUniqueValues[i].size() < n) {
                    repeatedElementsRows++;
                }
                if (columnsUniqueValues[i].size() < n) {
                    repeatedElementsColumns++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", tc, trace, repeatedElementsRows, repeatedElementsColumns);
        }
    }
}