import java.util.*;
import java.io.*;
import java.nio.*;
    public class Solution {
      public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            int trace=0, rows = 0, columns = 0;
            String temp;
            for (int j=0; j<n; j++) {
                temp = "";
                for (int k=0; k<n; k++) {
                    m[j][k] = in.nextInt();
                    temp+=m[j][k];
                    if (j == k) {
                        trace+=m[j][k];
                    }
                }
                if (temp.length() != temp.chars().distinct().count()) {
                    rows++;
                }
            }
            for (int k=0; k<n; k++) {
                temp = "";
                for (int j=0; j<n; j++) {
                    temp+=m[j][k];
                }
                if (temp.length() != temp.chars().distinct().count()) {
                    columns++;
                }
            }
            System.out.println("Case #" + i + ": "+trace + " "+ rows + " "+ columns);
        }
      }
    }