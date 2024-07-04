import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = sc.nextInt();
        
        for (int testCase = 1; testCase <= numTests; testCase++) {
            int trace = 0;
            int badRows = 0;
            int badCols = 0;
            int size = sc.nextInt();
            
            List<Integer> results = calculateTraceAndLatin(size, trace, badRows, badCols, sc);
            System.out.println("Case #" + testCase + ": " + results.get(0) + " " + results.get(1) + " " + results.get(2));
        }
        
        sc.close();
    }

    private static List<Integer> calculateTraceAndLatin(int size, int trace, int badRows, int badCols, Scanner sc) {
        List<Set<Integer>> rowSets = new ArrayList<>(size);
        List<Set<Integer>> colSets = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }
        
        Set<Integer> badRowSet = new HashSet<>();
        Set<Integer> badColSet = new HashSet<>();
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = sc.nextInt();
                
                if (row == col) {
                    trace += value;
                }
                
                if (!rowSets.get(row).add(value)) {
                    badRowSet.add(row);
                }
                
                if (!colSets.get(col).add(value)) {
                    badColSet.add(col);
                }
            }
        }
        
        badRows = badRowSet.size();
        badCols = badColSet.size();
        
        return Arrays.asList(trace, badRows, badCols);
    }
}