
import java.util.*;
import java.io.*;


/**
 * Google Code Jam 2020 - Round 0 - Solution A
 * @author : huls
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Boolean> rowHasDuplicate = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();
            Map<Integer, Boolean> colHasDuplicate = new HashMap<>();
            for (int init = 0; init < n; ++init) {
                rowHasDuplicate.put(init, false);
                rowMap.put(init, new HashSet<>());
                colHasDuplicate.put(init, false);
                colMap.put(init, new HashSet<>());
            }
            long sum = 0L;

            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    int value = in.nextInt();
                    matrix[row][col] = value;
                    if (row == col) sum += matrix[row][col];
                    if (!rowHasDuplicate.get(row)) {
                        if (rowMap.get(row).contains(value)) {
                            rowHasDuplicate.put(row, true);
                        } else {
                            rowMap.get(row).add(value);
                        }
                    }
                    if (!colHasDuplicate.get(col)) {
                        if (colMap.get(col).contains(value)) {
                            colHasDuplicate.put(col, true);
                        } else {
                            colMap.get(col).add(value);
                        }
                    }
                }
            }

            long rDupl = rowHasDuplicate.values().stream().filter(b -> b == true).count();
            long cDupl = colHasDuplicate.values().stream().filter(b -> b == true).count();
            System.out.println("Case #" + i + ": " + sum + " " + rDupl + " " + cDupl);
        }
    }
}
