import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int trace = 0;

            int n = in.nextInt();
            HashSet[] rows = new HashSet[n];
            HashSet[] cols = new HashSet[n];
            for (int j = 0; j < n; j++) {
                rows[j] = new HashSet<Integer>();
            }
            for (int j = 0; j < n; j++) {
                cols[j] = new HashSet<Integer>();
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int num = in.nextInt();
                    if (row == col) {
                        trace += num;
                    }
                    if (rows[row] != null && rows[row].contains(num)) {
                        rows[row] = null;
                    } else {
                        rows[row].add(num);
                    }
                    if (cols[col] != null && cols[col].contains(num)) {
                        cols[col] = null;
                    } else {
                        cols[col].add(num);
                    }
                }
            }
            int r = 0;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (rows[j] == null)
                    r++;
            }
            for (int j = 0; j < n; j++) {
                if (cols[j] == null)
                    c++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
