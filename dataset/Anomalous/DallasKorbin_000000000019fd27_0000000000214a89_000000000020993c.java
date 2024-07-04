import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = scanner.nextInt();
        
        for (int test = 1; test <= numTests; test++) {
            int size = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            List<Set<Integer>> columns = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                columns.add(new HashSet<>());
            }
            
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);
                    columns.get(col).add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() < size) {
                    duplicateRows++;
                }
            }
            
            for (Set<Integer> colSet : columns) {
                if (colSet.size() < size) {
                    duplicateCols++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", test, trace, duplicateRows, duplicateCols);
        }
    }
}