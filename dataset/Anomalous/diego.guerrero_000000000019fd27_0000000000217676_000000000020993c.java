import java.util.*;
import java.io.*;

public class Solution {
    private static final String CASE_TEMPLATE = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                rowMap.put(i, new HashSet<>());
                for (int j = 0; j < n; j++) {
                    if (!colMap.containsKey(j)) {
                        colMap.put(j, new HashSet<>());
                    }
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    rowMap.get(i).add(value);
                    colMap.get(j).add(value);
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowMap.get(i).size() != n) {
                    rowRepeats++;
                }
                if (colMap.get(i).size() != n) {
                    colRepeats++;
                }
            }

            System.out.println(String.format(CASE_TEMPLATE, testCase, trace, rowRepeats, colRepeats));
        }
    }
}