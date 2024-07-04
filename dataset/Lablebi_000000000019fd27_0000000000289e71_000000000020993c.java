import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int trace = 0;
            int rows = 0;
            int col = 0;
            int n = in.nextInt();
            int diagIndex = 0;
            Map<Integer, int[]> map = new HashMap<>();
            Set<Integer> duplicatedColums = new HashSet<>();
            for (int r = 0; r < n; r++) {
                boolean rowHasDuplication = false;
                int[] duplicatedRows = new int[n];
                for (int c = 0; c < n; c++) {
                    if (!map.containsKey(c)) {
                        map.put(c, new int[n]);
                    }
                    int m = in.nextInt();
                    if (c == diagIndex) {
                        trace += m;
                    }
                    if (duplicatedRows[m-1] == 0) {
                        duplicatedRows[m-1] = 1;
                    } else {
                        rowHasDuplication = true;
                    }
                    if (map.get(c)[m-1] == 0) {
                        map.get(c)[m-1] = 1;
                    } else {
                        duplicatedColums.add(c);
                    }
                }
                diagIndex++;
                if (rowHasDuplication) {
                    rows++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + duplicatedColums.size());
        }
    }
}