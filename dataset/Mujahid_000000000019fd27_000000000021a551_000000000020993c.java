package practice.codejam;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        ArrayList<ArrayList<Integer>> elems = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int lineNo = 0;
            while (lineNo <= n) {


                String elem = in.nextLine().replaceAll("\\s", "");
                char[] values = elem.toCharArray();
                for (char value : values) {

                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < n; b++) {
                            matrix[a][b] = Character.getNumericValue(value);
                        }
                    }
                }
                lineNo++;
            }

            for (int x = 0; x < matrix.length; x++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (x == j) sum = sum + matrix[x][j];
                }
            }


            System.out.println("Case #" + i + ": " + (sum) + " ");
            sum = 0;
        }
    }
}