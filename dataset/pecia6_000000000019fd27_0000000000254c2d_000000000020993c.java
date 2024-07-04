import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            System.out.println( "Case #" + k + ": " + solve(in, n));
        }
    }

    private static String solve (Scanner in, int n) {
        int[][] matrix = new int[n][n];
        int trace = 0;
        int duplicatedRow = 0;
        int duplicatedCol = 0;
        HashSet values = new HashSet<Integer>();

        //Fill matrix
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = in.nextInt();
                if (i==j) {
                    trace += v;
                }
                matrix [i][j] = v;
            }
        }

        //Scan Rows
        for (int i = 0; i < n; ++i) {
            values.clear();
            for (int j = 0; j < n; ++j) {
                int v = matrix [i][j];
                if (values.contains(v)) {
                    duplicatedRow++;
                    break;
                } else {
                    values.add(v);
                }
            }
        }

        //Scan Col
        for (int j = 0; j < n; ++j) {
            values.clear();
            for (int i = 0; i < n; ++i) {
                int v = matrix [i][j];
                if (values.contains(v)) {
                    duplicatedCol++;
                    break;
                } else {
                    values.add(v);
                }
            }
        }


       return  trace + " " + duplicatedRow + " " + duplicatedCol;

    }


}
