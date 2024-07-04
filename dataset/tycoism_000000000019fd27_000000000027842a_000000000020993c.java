import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            List<Set<Integer>> colList = new ArrayList<>(n);
            Set<Integer> rowSet = new HashSet<>(n);
            for(int col = 0; col < n; ++col) {
                colList.add(new HashSet<>(n));
                for (int row = 0; row < n; ++row) {
                    int num = in.nextInt();
                    colList.get(col).add(num);
                    rowSet.add(num);
                    // Calculate trace
                    if (col == row) trace += num;
                }
                // Calculate row;
                if (rowSet.size() != n)
                    ++rowCount;
                rowSet.clear();
            }
            for (int k=0; k<n; ++k) {
                if (colList.get(k).size() != n)
                    ++colCount;
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

}