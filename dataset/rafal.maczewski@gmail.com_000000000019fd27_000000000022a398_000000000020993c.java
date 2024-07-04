import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {

        int n = in.nextInt();
        HashSet<Integer> []cols = new HashSet[n];
        for (int i = 0; i < n; i++) {
            cols[i] = new HashSet<>();
        }
        int trace = 0;
        int repeatedCol = 0;
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                if (i == j) {
                    trace += x;
                }
                if (row != null) {
                    if (row.contains(x)) {
                        repeatedRows++;
                        row = null;
                    } else {
                        row.add(x);
                    }
                }
                HashSet<Integer> col = cols[j];
                if (col != null) {
                    if (col.contains(x)) {
                        repeatedCol++;
                        cols[j] = null;
                    } else {
                        col.add(x);
                    }
                }
            }
        }
        System.out.println("Case #" + caseNr + ": " + (trace) + " " + (repeatedRows) + " " + repeatedCol);

    }
}